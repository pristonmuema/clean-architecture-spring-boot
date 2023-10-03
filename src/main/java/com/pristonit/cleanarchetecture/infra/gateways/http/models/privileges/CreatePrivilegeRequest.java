package com.pristonit.cleanarchetecture.infra.gateways.http.models.privileges;


import com.pristonit.cleanarchetecture.domain.users.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record CreatePrivilegeRequest(@NotEmpty
                                     @Schema(example = "ADD_MEDICINE")
                                     String privilege,
                                     @NotEmpty
                                     @Schema(example = "NURSE")
                                     RoleType roleType,
                                     @NotEmpty
                                     @Schema(example = "For adding medicine")
                                     String description,
                                     @NotEmpty
                                     @Email(message = "Must be a valid email")
                                     @Schema(example = "muema@gmail.com")
                                     String createdBy) {


}
