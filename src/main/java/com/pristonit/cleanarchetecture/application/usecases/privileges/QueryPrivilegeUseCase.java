package com.pristonit.cleanarchetecture.application.usecases.privileges;


import com.pristonit.cleanarchetecture.application.services.privileges.PrivilegeQueryService;
import com.pristonit.cleanarchetecture.application.usecases.EPage;
import com.pristonit.cleanarchetecture.application.usecases.FilterPageRequest;
import com.pristonit.cleanarchetecture.application.usecases.exceptions.privileges.NoSuchPrivilegeFoundException;
import com.pristonit.cleanarchetecture.application.usecases.privileges.dtos.PrivilegeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryPrivilegeUseCase {

	PrivilegeQueryService privilegeQueryService;

	@Autowired
	public QueryPrivilegeUseCase(PrivilegeQueryService privilegeQueryService) {
		this.privilegeQueryService = privilegeQueryService;
	}

	public PrivilegeDto getPrivilege(String privilege) {
		return privilegeQueryService.getOptionalPrivilege(privilege)
		                            .orElseThrow(() -> new NoSuchPrivilegeFoundException(privilege));
	}

	public EPage<PrivilegeDto> getPrivileges(int page, int size) {
		FilterPageRequest pageRequest = new FilterPageRequest(page, size);
		return privilegeQueryService.getPrivileges(pageRequest);
	}


}
