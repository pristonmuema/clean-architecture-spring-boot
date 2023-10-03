package com.pristonit.cleanarchetecture.application.usecases.utils;

import com.pristonit.cleanarchetecture.application.usecases.privileges.dtos.PrivilegeDto;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserRequestDto;
import com.pristonit.cleanarchetecture.domain.users.Privilege;
import com.pristonit.cleanarchetecture.domain.users.User;

public class ModelUtils {

	public static UserRequestDto toDto(User user) {
		return new UserRequestDto(user.getFirstName(),
		                          user.getSecondName(),
		                          user.getEmail(),
		                          user.getPrimaryPhoneNumber(),
		                          user.getSecondaryPhoneNumber(),
		                          user.getPrivileges().stream().map(ModelUtils::toDto).toList(),
		                          user.getCreatedAt(),
		                          user.getUpdatedAt());
	}

	public static PrivilegeDto toDto(Privilege privilege) {
		return new PrivilegeDto(Math.toIntExact(privilege.getId()),
		                        privilege.getFunctionality(),
		                        privilege.getRoleType(),
		                        privilege.getDescription(),
		                        privilege.getCreatedBy(),
		                        privilege.getCreatedAt(),
		                        privilege.getUpdatedAt());
	}


}
