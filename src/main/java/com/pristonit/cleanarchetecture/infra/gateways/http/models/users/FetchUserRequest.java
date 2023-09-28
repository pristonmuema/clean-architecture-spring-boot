package com.pristonit.cleanarchetecture.infra.gateways.http.models.users;

import com.pristonit.cleanarchetecture.domain.users.RoleType;
import java.time.LocalDateTime;
import java.util.List;

public record FetchUserRequest(String firstName, String secondName, String email,
                               String primaryPhoneNo, String secondaryPhoneNo, RoleType roleType,
                               List<PrivilegeRequest> privileges, LocalDateTime createdAt,
                               LocalDateTime updatedAt) {

}
