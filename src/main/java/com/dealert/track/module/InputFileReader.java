package com.dealert.track.module;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class InputFileReader {
	private List<String> lines;

	public void readFile() throws FileNotFoundException, IOException {
		// reads the file from the resource floderS
		ClassLoader classLoader = InputFileReader.class.getClassLoader();
		File file = new File(classLoader.getResource("input/inputFile")
				.getFile());
		// Assuming file size is small it not big data ,if it very large then we
		// need split the file and read.
		lines = Files.readAllLines(file.toPath());

	}

	public List<String> getLines() {
		return lines;
	}

}
