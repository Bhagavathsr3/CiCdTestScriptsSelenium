package com.Conference.ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

 private static Properties prop = new Properties();
	public static void loadConfig(String env) throws IOException {
		
		File file = new File("src/test/resources/"+env+".properties");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		prop.load(fileInputStream);
		
		}
	public static String getKeyValue(String key) {
		String value = prop.getProperty(key);
		return value;
	}
}
