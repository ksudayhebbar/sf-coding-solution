package com.dealert.track.module;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*Base Class for the  creates the thread pool and reads the file does the mapper */
public class KeyCountExecutor {
	final private ExecutorService pool;
	final protected KeyCounts keycount;

	public KeyCountExecutor() {
		pool = Executors.newFixedThreadPool(4);
		keycount = new KeyCounts();
		InputFileReader inputFileReader = new InputFileReader();
		try {
			inputFileReader.readFile();
			List<String> lines = inputFileReader.getLines();
			for (String line : lines) {
				pool.submit(new InputWriter(keycount, line));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		try {
			pool.awaitTermination(10L, TimeUnit.MILLISECONDS);
			pool.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public KeyCounts getKeycount() {
		return keycount;
	}

	public void executeKeyCount() {
		KeyCountExecutor countExecutor = new KeyCountExecutor();
		countExecutor.getKeycount().displayWordCount();
	}
}
