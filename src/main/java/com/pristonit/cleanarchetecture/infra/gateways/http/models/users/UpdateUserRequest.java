package com.pristonit.cleanarchetecture.infra.gateways.http.models.users;

import com.pristonit.cleanarchetecture.domain.users.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record UpdateUserRequest(@NotEmpty(message = "First Name should not be empty")
                                @Schema(example = "Priston")
                                String firstName,
                                @NotEmpty(message = "Second Name should not be empty")
                                @Schema(example = "Muema")
                                String secondName,
                                @Schema(example = "254704678754")
                                String primaryPhoneNo,
                                @Schema(example = "254705066065")
                                String secondaryPhoneNo,
                                @Schema(example = "NURSE")
                                @NotEmpty(message = "RoleType should not be empty")
                                RoleType roleTypee) {

}
