package com.pristonit.cleanarchetecture.application.usecases.users.dtos;

import com.pristonit.cleanarchetecture.domain.users.RoleType;
import java.time.LocalDateTime;
import java.util.List;

public record UserRequestDto(String firstName, String secondName, String email,
                             String primaryPhoneNo, String secondaryPhoneNo,
                             RoleType roleType, List<PrivilegeDto> privilegeDtos,
                             LocalDateTime createdAt,
                             LocalDateTime updatedAt) {

}
