package com.dealert.track.module;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyCounts {
	private Map<String, Integer> wordCountMapper = new ConcurrentHashMap<String, Integer>();

	public void insertWord(String word, int count) {
		if (wordCountMapper.containsKey(word)) {
			Integer ntempValue = wordCountMapper.get(word);
			wordCountMapper.put(word, ntempValue + count);
		} else {
			wordCountMapper.put(word, count);
		}
	}

	public void displayWordCount() {
		for (Map.Entry<String, Integer> values : wordCountMapper.entrySet()) {
			System.out.println(values.getKey() + " : " + values.getValue());
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
