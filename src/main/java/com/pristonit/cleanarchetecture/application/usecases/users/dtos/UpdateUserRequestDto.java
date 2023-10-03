package com.pristonit.cleanarchetecture.application.usecases.users.dtos;

public record UpdateUserRequestDto(String firstName, String secondName, String primaryPhoneNo,
                                   String secondaryPhoneNo) {

}
