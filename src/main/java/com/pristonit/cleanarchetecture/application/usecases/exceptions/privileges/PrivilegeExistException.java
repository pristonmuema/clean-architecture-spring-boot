package com.pristonit.cleanarchetecture.application.usecases.exceptions.privileges;

public class PrivilegeExistException extends RuntimeException {

	private final String privilege;


	public PrivilegeExistException(String privilege) {
		this.privilege = privilege;
	}

	public String getPrivilege() {
		return privilege;
	}
}
