package com.fitmind.utils;

import java.util.UUID;

public class ImageCode {
	
	public static String generateImageCode(Integer len) {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, len);
    }

}
