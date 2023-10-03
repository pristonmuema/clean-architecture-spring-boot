package com.pristonit.cleanarchetecture.application.usecases.users.dtos;

import com.pristonit.cleanarchetecture.application.usecases.privileges.dtos.PrivilegeDto;
import java.time.LocalDateTime;
import java.util.List;

public record UserRequestDto(String firstName, String secondName, String email,
                             String primaryPhoneNo, String secondaryPhoneNo,
                              List<PrivilegeDto> privilegeDtos,
                             LocalDateTime createdAt,
                             LocalDateTime updatedAt) {

}
