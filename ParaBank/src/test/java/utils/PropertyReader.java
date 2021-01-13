package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Gives access to properties
 */
public class PropertyReader {
	public static Properties getProperties() {
		Properties props = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("resources/framework.properties");
			props.load(in);
			in.close();
		}
		catch (IOException e) {
		}
		return  props;

	}
	public static String getPropertie(String key) {
		Properties props = getProperties();
		return getPropertie(key);
	}

}
