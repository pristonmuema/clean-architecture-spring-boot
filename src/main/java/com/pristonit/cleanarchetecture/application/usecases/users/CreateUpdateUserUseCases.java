package com.pristonit.cleanarchetecture.application.usecases.users;

import com.pristonit.cleanarchetecture.application.services.privileges.PrivilegeService;
import com.pristonit.cleanarchetecture.application.services.users.UserService;
import com.pristonit.cleanarchetecture.application.usecases.exceptions.users.NoSuchUserFoundException;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.CreateUserRequestDto;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UpdateUserRequestDto;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserResponseDto;
import com.pristonit.cleanarchetecture.domain.users.Privilege;
import com.pristonit.cleanarchetecture.domain.users.RoleType;
import com.pristonit.cleanarchetecture.domain.users.User;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUpdateUserUseCases {

	Logger logger = LoggerFactory.getLogger(CreateUpdateUserUseCases.class);
	UserService userService;
	PrivilegeService privilegeService;
	@Autowired
	public CreateUpdateUserUseCases(UserService userService, PrivilegeService privilegeService) {
		this.userService = userService;
		this.privilegeService = privilegeService;
	}


	public UserResponseDto createUser(CreateUserRequestDto requestDto) {
		User user = new User(requestDto.firstName(),
		                     requestDto.secondName(),
		                     requestDto.email(),
		                     requestDto.password(),
		                     requestDto.primaryPhoneNo(),
		                     requestDto.secondaryPhoneNo(),
		                     getPrivileges(requestDto.roleType()));
		userService.saveUser(user);
		logger.info("User {} has been created", user.getEmail());
		return new UserResponseDto(user.getEmail());
	}

	private List<Privilege> getPrivileges(RoleType roleType) {
		return privilegeService.findByRoleType(roleType);
	}

	public UserResponseDto updateUser(String email, UpdateUserRequestDto requestDto) {
		var user = userService.getOptionalUser(email)
		                      .orElseThrow(() -> new NoSuchUserFoundException(email));
		user.setFirstName(requestDto.firstName());
		user.setSecondName(requestDto.secondName());
		user.setPrimaryPhoneNumber(requestDto.primaryPhoneNo());
		user.setSecondaryPhoneNumber(requestDto.secondaryPhoneNo());
		userService.updateUser(user);
		logger.info("User {} has been updated", user.getEmail());
		return new UserResponseDto(user.getEmail());
	}


}
