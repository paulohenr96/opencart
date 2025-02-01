package opencart.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtility extends Utility{

	
	public static String generateString() {
		return RandomStringUtils.randomAlphabetic(7);
	}
	
	public static String generateNumeric() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	public static String generateAlphanumeric() {
		return RandomStringUtils.randomNumeric(3)+RandomStringUtils.randomAlphabetic(3);
	}
}
