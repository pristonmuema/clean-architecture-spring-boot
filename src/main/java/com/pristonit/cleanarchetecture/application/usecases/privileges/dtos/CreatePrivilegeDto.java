package com.pristonit.cleanarchetecture.application.usecases.privileges.dtos;


import com.pristonit.cleanarchetecture.domain.users.RoleType;

public record CreatePrivilegeDto(String privilege, RoleType roleType, String description,
                                 String createdBy) {

}
