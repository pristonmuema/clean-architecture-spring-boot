package com.pristonit.cleanarchetecture.infra.gateways.http.models.users;

import com.pristonit.cleanarchetecture.domain.users.RoleType;
import java.util.List;

public record CreateUserRequest(String firstName, String secondName, String email,
                                String password, String primaryPhoneNo, String secondaryPhoneNo,
                                RoleType roleType, List<String> privileges) {


}
