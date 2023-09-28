package com.pristonit.cleanarchetecture.application.services.users;

import com.pristonit.cleanarchetecture.application.usecases.EPage;
import com.pristonit.cleanarchetecture.application.usecases.FilterPageRequest;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserRequestDto;
import java.util.Optional;

public interface UserQueryService {

	Optional<UserRequestDto> optionalUser(String email);

	EPage<UserRequestDto> getAllUsers(FilterPageRequest pageRequest, String privileges);

}
