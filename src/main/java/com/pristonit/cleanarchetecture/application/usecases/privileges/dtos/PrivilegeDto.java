package com.pristonit.cleanarchetecture.application.usecases.privileges.dtos;

import com.pristonit.cleanarchetecture.domain.users.RoleType;
import java.time.LocalDateTime;

public record PrivilegeDto(int id, String privilege, RoleType roleType, String description,
                           String createdBy, LocalDateTime createdAt, LocalDateTime updatedAt) {

}
