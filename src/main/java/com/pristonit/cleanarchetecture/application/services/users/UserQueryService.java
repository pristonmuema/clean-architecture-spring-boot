package com.pristonit.cleanarchetecture.application.services.users;


import com.pristonit.cleanarchetecture.application.usecases.EPage;
import com.pristonit.cleanarchetecture.application.usecases.FilterPageRequest;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserRequestDto;
import com.pristonit.cleanarchetecture.domain.users.RoleType;
import java.util.Optional;

public interface UserQueryService {

	Optional<UserRequestDto> optionalUser(String email);

	EPage<UserRequestDto> getAllUsers(FilterPageRequest pageRequest, RoleType roleType);

}
