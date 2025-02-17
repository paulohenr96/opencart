package opencart.utility;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;

import opencart.test.base.BaseTest;

public class PropertiesUtil {

	protected static Logger logger = Logger.getLogger(PropertiesUtil.class);
	private static Properties p;

	public static String getProperty(String propertie) {

		return p.getProperty(propertie);
	}

	public static void loadProperties() {
		p = new Properties();
		try {
			FileReader file = new FileReader("./src//test//resources//config.properties");
			p.load(file);
		} catch (Exception e) {
			logger.fatal("Problem loading the properties => " + e.getLocalizedMessage());
		}

	}
}
