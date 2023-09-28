package com.pristonit.cleanarchetecture.application.usecases.exceptions.users;

public class NoSuchUserFoundException extends RuntimeException{

	private final String email;

	public NoSuchUserFoundException(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
