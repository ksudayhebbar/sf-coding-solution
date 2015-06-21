package com.dealert.track.module;
/*Thread which executes parallel for the each line in the file */
public class InputWriter implements Runnable {
	private KeyCounts keyCount;
	private String stringLine;
	public InputWriter(KeyCounts keyCount, String line) {
		this.keyCount = keyCount;
		this.stringLine = line;
	}

	public void run() {
		String[] split = stringLine.split(",");
		if (split.length > 1) {
			keyCount.insertWord(split[0].toString().trim(),
					Integer.valueOf(split[1].toString().trim()));
		}

	}

}
