package com.pristonit.cleanarchetecture.application.usecases.privileges;

import com.pristonit.cleanarchetecture.application.services.privileges.PrivilegeService;
import com.pristonit.cleanarchetecture.application.usecases.exceptions.privileges.PrivilegeExistException;
import com.pristonit.cleanarchetecture.application.usecases.privileges.dtos.CreatePrivilegeDto;
import com.pristonit.cleanarchetecture.application.usecases.privileges.dtos.PrivilegeResponseDto;
import com.pristonit.cleanarchetecture.domain.users.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUpdatePrivilegeUseCase {

	PrivilegeService privilegeService;

	@Autowired
	public CreateUpdatePrivilegeUseCase(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	public PrivilegeResponseDto createPrivilege(CreatePrivilegeDto dto) {
		var result = privilegeService.optionalPrivilege(dto.privilege());
		if (result.isPresent()) {
			throw new PrivilegeExistException(result.get().getFunctionality());
		}
		var newPrivilege = new Privilege(dto.privilege(), dto.description(), dto.roleType(),
		                                 dto.createdBy());
		privilegeService.save(newPrivilege);
		return new PrivilegeResponseDto(newPrivilege.getFunctionality());
	}
}
