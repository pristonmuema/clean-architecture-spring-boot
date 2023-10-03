package com.pristonit.cleanarchetecture.application.usecases.exceptions.users;

public class UserExistException extends RuntimeException {

	private final String email;

	public UserExistException(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
