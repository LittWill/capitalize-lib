package com.wnra.capitalize.util;

public class Formatacoes {

	public static String capitalize(String param) {
		if (param == null || param.equals("")) {
			return null;
		}

		char[] paramCharArray = param.trim().toLowerCase().toCharArray();

		paramCharArray[0] = Character.toUpperCase(paramCharArray[0]);
		for (int i = 0; i < paramCharArray.length; i++) {
			if (Character.isWhitespace(paramCharArray[i])) {
				paramCharArray[i + 1] = Character.toUpperCase(paramCharArray[i + 1]);
			}
		}

		return String.valueOf(paramCharArray);
	}

}
