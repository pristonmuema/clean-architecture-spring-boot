package com.pristonit.cleanarchetecture.application.services.privileges;


import com.pristonit.cleanarchetecture.application.usecases.EPage;
import com.pristonit.cleanarchetecture.application.usecases.FilterPageRequest;
import com.pristonit.cleanarchetecture.application.usecases.privileges.dtos.PrivilegeDto;
import java.util.Optional;

public interface PrivilegeQueryService {

	EPage<PrivilegeDto> getPrivileges(FilterPageRequest request);

	Optional<PrivilegeDto> getOptionalPrivilege(String functionality);

}
