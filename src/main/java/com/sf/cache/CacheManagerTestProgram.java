package com.sf.cache;

import org.junit.Before;
import org.junit.Test;

public class CacheManagerTestProgram {

	@Before
	public void setup() {

	}

	@Test
	public void CacheManager() {
		String s = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		CachedObject co = new CachedObject(s, new Long(1234), 1);
		/* Place the object into the cache! */
		CacheManager.put(co);
		/* Try to retrieve the object from the cache! */
		CachedObject o = (CachedObject) CacheManager.get(new Long(1234));
		/* Let's see if we got it! */
		if (o == null)
			System.out
					.println("CacheManagerTestProgram.Main:  FAILURE!  Object not Found.");
		else
			System.out.println("CacheManagerTestProgram.Main:  SUCCESS! "
					+ ((String) o.object).toString());
	}

}
