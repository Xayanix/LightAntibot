package net.xayanix.antibot.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomUtils {
	private static SecureRandom random = new SecureRandom();

	public static String randomCode() {
		return new BigInteger(25, random).toString(32);
	}
}
