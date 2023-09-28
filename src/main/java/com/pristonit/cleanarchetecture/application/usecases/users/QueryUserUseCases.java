package com.pristonit.cleanarchetecture.application.usecases.users;

import com.pristonit.cleanarchetecture.application.services.users.UserQueryService;
import com.pristonit.cleanarchetecture.application.usecases.EPage;
import com.pristonit.cleanarchetecture.application.usecases.FilterPageRequest;
import com.pristonit.cleanarchetecture.application.usecases.exceptions.users.NoSuchUserFoundException;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryUserUseCases {

	UserQueryService userQueryService;

	@Autowired
	public QueryUserUseCases(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}

	public UserRequestDto getUser(String email) {
		return userQueryService.optionalUser(email)
		                       .orElseThrow(() -> new NoSuchUserFoundException(email));
	}

	public EPage<UserRequestDto> getUsers(int size, int page, String privileges) {
		FilterPageRequest pageRequest = new FilterPageRequest(page, size);
		return userQueryService.getAllUsers(pageRequest, privileges);
	}
}
