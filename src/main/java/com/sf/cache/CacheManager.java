package com.sf.cache;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class CacheManager {
	private static ConcurrentHashMap cacheHashMap = new ConcurrentHashMap();

	public CacheManager() {

		Thread cacheCleaner = new Thread(new Runnable() {
			int milliSecondSleepTime = 5000;

			@Override
			public void run() {
				try {
					while (true) {

						KeySetView keySet = cacheHashMap.keySet();
						Iterator iterator = keySet.iterator();
						while (iterator.hasNext()) {
							Object key = iterator.next();
							Cacheable value = (Cacheable) cacheHashMap.get(key);
							if (value.isExpired()) {
								cacheHashMap.remove(key);
								System.out
										.println("Thread Cleaner Running.Found an Expired Object in the Cache.");
							}
						}

						Thread.sleep(milliSecondSleepTime);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}
		}, "CacheCleaner");

		cacheCleaner.start();
		cacheCleaner.setDaemon(true);
		cacheCleaner.setPriority(Thread.MIN_PRIORITY);
	}

	public static void put(Cacheable object) {
		cacheHashMap.put(object.getIdentifier(), object);

	}

	public static Cacheable get(Object obj) {

		Object object = null;
		object = (Cacheable) cacheHashMap.get(obj);

		if (object != null) {
			return (Cacheable) object;
		} else {
			return null;
		}

	}
}
