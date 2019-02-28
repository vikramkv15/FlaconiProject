package com.flaconi.testRequistie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestDataValueReader {

	public static String readPropFile(String propKey) {
		String dirPath = System.getProperty("user.dir");
		String propData = null;
		File file = new File(dirPath+"\\src\\main\\resources\\datafile.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		propData = prop.getProperty(propKey);

		return propData;
	}
}
