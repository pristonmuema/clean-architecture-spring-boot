package com.pristonit.cleanarchetecture.infra.gateways.http.models;


import com.pristonit.cleanarchetecture.application.usecases.privileges.dtos.CreatePrivilegeDto;
import com.pristonit.cleanarchetecture.application.usecases.privileges.dtos.PrivilegeDto;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.CreateUserRequestDto;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UpdateUserRequestDto;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserRequestDto;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.privileges.CreatePrivilegeRequest;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.privileges.PrivilegeResponse;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.users.CreateUserRequest;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.users.FetchUserRequest;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.users.UpdateUserRequest;

public class ModelUtil {

	public static CreateUserRequestDto toDto(CreateUserRequest request) {
		return new CreateUserRequestDto(request.firstName(),
		                                request.secondName(),
		                                request.email(),
		                                request.password(),
		                                request.primaryPhoneNo(),
		                                request.secondaryPhoneNo(),
		                                request.roleType());
	}

	public static UpdateUserRequestDto toDto(UpdateUserRequest request) {
		return new UpdateUserRequestDto(request.firstName(),
		                                request.secondName(),
		                                request.primaryPhoneNo(),
		                                request.secondaryPhoneNo());
	}

	public static FetchUserRequest toDto(UserRequestDto requestDto) {
		return new FetchUserRequest(requestDto.firstName(),
		                            requestDto.secondName(),
		                            requestDto.email(),
		                            requestDto.primaryPhoneNo(),
		                            requestDto.secondaryPhoneNo(),
		                            requestDto.privilegeDtos().stream().map(PrivilegeDto::privilege)
		                                      .toList(),
		                            requestDto.createdAt(),
		                            requestDto.updatedAt()
		);
	}

	public static PrivilegeResponse toDto(PrivilegeDto privilegeDto) {
		return new PrivilegeResponse(privilegeDto.id(),
		                             privilegeDto.privilege(),
		                             privilegeDto.roleType(),
		                             privilegeDto.description(),
		                             privilegeDto.createdBy(),
		                             privilegeDto.createdAt(),
		                             privilegeDto.updatedAt());
	}

	public static CreatePrivilegeDto toDto(CreatePrivilegeRequest request) {
		return new CreatePrivilegeDto(request.privilege(),
		                              request.roleType(),
		                              request.description(),
		                              request.createdBy());
	}
}
