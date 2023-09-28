package com.pristonit.cleanarchetecture.application.usecases.users.dtos;

import com.pristonit.cleanarchetecture.domain.users.RoleType;
import java.util.List;

public record CreateUserRequestDto(String firstName, String secondName, String email,
                                   String password, String primaryPhoneNo, String secondaryPhoneNo,
                                   RoleType roleType, List<String> privileges) {

}
