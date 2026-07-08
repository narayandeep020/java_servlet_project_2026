package com.crud;

public class Util {

	public static boolean containsDigit(String str) {
	if (str == null || str.isEmpty()) {
        return false;
    }
    for (int i = 0; i < str.length(); i++) {
        if (Character.isDigit(str.charAt(i))) {
            return true; // Stop and return true on the first digit found
        }
    }
    return false;

	}
}
