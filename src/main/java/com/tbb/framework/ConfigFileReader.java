package com.tbb.framework;

import java.util.Enumeration;

import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.tbb.constants.TestConsts;

/**
 * This class reads the config file (for example selenikum.properties). Using
 * various methods of this file we can read complete config file, read value of
 * a particular key(configuration parameter) and set the value of a
 * configuration parameter.
 * 
 * @author Xebia
 * 
 */
public class ConfigFileReader {
	private static Properties configProperties;
	private static final Logger logger = Logger
			.getLogger(ConfigFileReader.class);
	static {
		DOMConfigurator.configure("src/test/java/resources/config/log4j.xml");
	}

	/**
	 * This method reads given properties file. It creates key-value pairs and updates value of those parameters
	 * that are given at run time like selenium's browser and IP.
	 * @param configFileName Name of properties file.
	 */
	public static void readConfig(String configFileName) {

		ResourceBundle rb = null;

		try {
			logger.debug("Reading the config file: " + configFileName);
			rb = ResourceBundle.getBundle(configFileName);
		} catch (NullPointerException npe) {
			logger.fatal("Properties file value is null", npe);
			System.exit(-1);
		} catch (MissingResourceException mre) {
			logger.fatal("Properties file not found", mre);
			System.exit(-1);
		}

		if (rb == null) {
			logger.fatal("Resource Bundle object is null");
			System.exit(-1);
		}

		Enumeration<String> e = rb.getKeys();

		if (configProperties == null) {
			configProperties = new Properties();
		}

		logger.debug("Found following key-value pairs in config file: ");
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			String value = rb.getString(key).trim();
			configProperties.setProperty(key, value);
			if (!key.contains("pass"))
				logger.debug(key + " : " + value);
		}

		if (System.getProperty("selenium.application") != null) {
			ConfigFileReader.setConfigItemValue("app_ip",
					System.getProperty("selenium.application"));
		}

		if (System.getProperty("selenium.browser") != null) {
			String cmd_browser = "*" + System.getProperty("selenium.browser");
			ConfigFileReader.setConfigItemValue("browser", cmd_browser);
		}

	}

	/**
	 * This method returns the value of given config parameter.
	 * @param configItemName Name of configuration parameter
	 * @return Value of given config parameter.
	 */
	public static String getConfigItemValue(String configItemName) {
		if (configProperties == null) {
			readConfig(TestConsts.CONFIG_FILE);
		}

		return configProperties.getProperty(configItemName);
	}

	/**
	 * This method sets the given value for given parameter.
	 * @param configItemName Name of config parameter to be updated
	 * @param Value New Value of parameter to be updated.
	 */
	public static void setConfigItemValue(String configItemName, String Value) {
		configProperties.setProperty(configItemName, Value);
	}

}
