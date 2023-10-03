package com.pristonit.cleanarchetecture.application.usecases.exceptions.privileges;

public class NoSuchPrivilegeFoundException extends RuntimeException{

	private final String privilege;

	public NoSuchPrivilegeFoundException(String privilege) {
		this.privilege = privilege;
	}

	public String getPrivilege() {
		return privilege;
	}
}
