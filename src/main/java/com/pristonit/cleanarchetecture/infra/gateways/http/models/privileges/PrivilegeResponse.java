package com.pristonit.cleanarchetecture.infra.gateways.http.models.privileges;

import com.pristonit.cleanarchetecture.domain.users.RoleType;
import java.time.LocalDateTime;

public record PrivilegeResponse(int id, String privilege, RoleType roleType, String description,
                                String createdBy, LocalDateTime createdAt,
                                LocalDateTime updatedAt) {

}
