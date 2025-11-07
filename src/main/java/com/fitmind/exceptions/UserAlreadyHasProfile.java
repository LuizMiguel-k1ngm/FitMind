package com.fitmind.exceptions;

public class UserAlreadyHasProfile extends RuntimeException {
	
	public UserAlreadyHasProfile(String message) {
		super(message);
	}
	
}
