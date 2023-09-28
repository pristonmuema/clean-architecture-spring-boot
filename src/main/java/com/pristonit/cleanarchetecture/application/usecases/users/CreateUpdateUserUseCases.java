package com.pristonit.cleanarchetecture.application.usecases.users;

import com.pristonit.cleanarchetecture.application.services.users.UserService;
import com.pristonit.cleanarchetecture.application.services.users.UserServiceImpl;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.CreateUserRequestDto;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserResponseDto;
import com.pristonit.cleanarchetecture.domain.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUpdateUserUseCases {

	UserService userService;


	@Autowired
	public CreateUpdateUserUseCases(UserServiceImpl userService) {
		this.userService = userService;
	}

	public UserResponseDto createUser(CreateUserRequestDto requestDto) {
		User user = new User(requestDto.firstName(),
		                     requestDto.secondName(),
		                     requestDto.email(),
		                     requestDto.password(),
		                     requestDto.primaryPhoneNo(),
		                     requestDto.secondaryPhoneNo(),
		                     requestDto.roleType());
		userService.saveUser(user);
		return new UserResponseDto(requestDto.email());
	}


}
