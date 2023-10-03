package com.pristonit.cleanarchetecture.infra.gateways.http.models.users;

import java.time.LocalDateTime;
import java.util.List;

public record FetchUserRequest(String firstName, String secondName, String email,
                               String primaryPhoneNo, String secondaryPhoneNo,
                               List<String> privileges, LocalDateTime createdAt,
                               LocalDateTime updatedAt) {

}
