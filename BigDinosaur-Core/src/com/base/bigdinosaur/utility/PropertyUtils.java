package com.base.bigdinosaur.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public  class PropertyUtils {
	public static Properties getPropertyObject() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			  input = PropertyUtils.class.getClassLoader().getResourceAsStream("config.properties");

//			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

}
