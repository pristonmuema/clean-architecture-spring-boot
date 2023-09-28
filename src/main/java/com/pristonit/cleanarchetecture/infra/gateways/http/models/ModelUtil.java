package com.pristonit.cleanarchetecture.infra.gateways.http.models;

import com.pristonit.cleanarchetecture.application.usecases.users.dtos.CreateUserRequestDto;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.PrivilegeDto;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserRequestDto;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.users.CreateUserRequest;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.users.FetchUserRequest;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.users.PrivilegeRequest;

public class ModelUtil {

	public static CreateUserRequestDto toDto(CreateUserRequest request) {
		return new CreateUserRequestDto(request.firstName(),
		                                request.secondName(),
		                                request.email(),
		                                request.password(),
		                                request.primaryPhoneNo(),
		                                request.secondaryPhoneNo(),
		                                request.roleType(),
		                                request.privileges());
	}

	public static FetchUserRequest toDto(UserRequestDto requestDto) {
		return new FetchUserRequest(requestDto.firstName(),
		                            requestDto.secondName(),
		                            requestDto.email(),
		                            requestDto.primaryPhoneNo(),
		                            requestDto.secondaryPhoneNo(),
		                            requestDto.roleType(),
		                            requestDto.privilegeDtos().stream().map(ModelUtil::toDto).toList(),
		                            requestDto.createdAt(),
		                            requestDto.updatedAt()
		);
	}

	public static PrivilegeRequest toDto(PrivilegeDto privilegeDto) {
		return new PrivilegeRequest(privilegeDto.id(), privilegeDto.privilege());
	}

}
