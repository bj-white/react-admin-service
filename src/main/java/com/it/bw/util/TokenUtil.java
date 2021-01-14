package com.it.bw.util;

import java.util.UUID;

public class TokenUtil {
	
	public static void main(String[] args) {
		getToken();
	}
	
	public static String getToken () {
		return UUID.randomUUID().toString();
	}
	
}
