package com.pristonit.cleanarchetecture.infra.gateways.http.models.users;

import com.pristonit.cleanarchetecture.domain.users.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(@NotEmpty(message = "First Name should not be empty")
                                @Schema(example = "Priston")
                                String firstName,
                                @NotEmpty(message = "Second Name should not be empty")
                                @Schema(example = "Muema")
                                String secondName,
                                @NotEmpty(message = "Email should not be empty")
                                @Schema(example = "muema@gmail.com")
                                @Email(message = "Please provide a valid message")
                                String email,
                                @NotEmpty(message = "Password should not be empty")
                                @Size(min = 8, max = 200)
                                String password,
                                @Schema(example = "254704678754")
                                String primaryPhoneNo,
                                @Schema(example = "254705066065")
                                String secondaryPhoneNo,
                                @Schema(example = "NURSE")
                                @NotEmpty(message = "RoleType should not be empty")
                                RoleType roleType) {


}
