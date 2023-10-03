package com.pristonit.cleanarchetecture.application.usecases.users.dtos;

import com.pristonit.cleanarchetecture.domain.users.RoleType;

public record CreateUserRequestDto(String firstName, String secondName, String email,
                                   String password, String primaryPhoneNo, String secondaryPhoneNo,
                                   RoleType roleType) {

}
