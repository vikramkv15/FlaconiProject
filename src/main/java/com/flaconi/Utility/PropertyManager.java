package com.flaconi.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	private static PropertyManager instance;
	private static final Object lock = new Object();
	private static String dirPath = System.getProperty("user.dir");
	private static String propertyFilePath = dirPath+"\\src\\main\\resources\\datafile.properties";
	private static String url;
	private static String expectedPerfumeName;
	private static String driverPath;
	private static String matchingPerfume;
	private static String EvidencePath;
	private static String Headless;

	// Create a Singleton instance. We need only one instance of Property Manager.
	public static PropertyManager getInstance() {
		if (instance == null) {
			synchronized (lock) {
				instance = new PropertyManager();
				instance.loadData();
			}
		}
		return instance;
	}

	// Get all configuration data and assign to related fields.
	private void loadData() {
		// Declare a properties object
		Properties prop = new Properties();

		// Read configuration.properties file
		try {
			prop.load(new FileInputStream(propertyFilePath));
			// prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
		} catch (IOException e) {
			System.out.println("Configuration properties file cannot be found");
		}

		// Get properties from configuration.properties
		url = prop.getProperty("url");
		expectedPerfumeName = prop.getProperty("expectedPerfumeName");
		driverPath = prop.getProperty("driverPath");
		matchingPerfume = prop.getProperty("matchingPerfume");
		EvidencePath = prop.getProperty("EvidencePath");
		Headless = prop.getProperty("Headless");

	}

	public String getURL() {
		return url;
	}

	public String getexpectedPerfumeName() {
		return expectedPerfumeName;
	}

	public String getdriverPath() {
		return driverPath;
	}

	public String getMatchingPerfume() {
		return matchingPerfume;
	}

	public String getEvidencePath() {
		return EvidencePath;
	}

	public String getHeadlessValue() {
		return Headless;
	}
}
