package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties props;

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public static String getData(String data) throws IOException {
		loadData();
		data = props.getProperty(data);
		return data;
	}
	public static void loadData() throws IOException {
		props = new Properties();
		File file = new File(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
		FileReader fileInput = new FileReader(file);
		props.load(fileInput);
	}
}
