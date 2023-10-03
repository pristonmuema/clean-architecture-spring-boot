package com.pristonit.cleanarchetecture.infra.repositories.privileges;

import com.pristonit.cleanarchetecture.application.services.privileges.PrivilegeQueryService;
import com.pristonit.cleanarchetecture.application.services.privileges.PrivilegeService;
import com.pristonit.cleanarchetecture.application.usecases.EPage;
import com.pristonit.cleanarchetecture.application.usecases.FilterPageRequest;
import com.pristonit.cleanarchetecture.application.usecases.privileges.dtos.PrivilegeDto;
import com.pristonit.cleanarchetecture.application.usecases.utils.ModelUtils;
import com.pristonit.cleanarchetecture.domain.users.Privilege;
import com.pristonit.cleanarchetecture.domain.users.RoleType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class PrivilegeStore implements PrivilegeService, PrivilegeQueryService {

	PrivilegeRepository privilegeRepository;

	@Autowired
	public PrivilegeStore(PrivilegeRepository privilegeRepository) {
		this.privilegeRepository = privilegeRepository;
	}

	@Override
	public EPage<PrivilegeDto> getPrivileges(FilterPageRequest request) {
		PageRequest pageable = PageRequest.of(request.page(), request.size(),
		                                      Sort.by("createdAt").descending());
		var results = privilegeRepository.findAll(pageable);
		return new EPage<>(results.getPageable().getPageNumber(), results.getPageable().getPageSize(),
		                   results.getTotalPages(),
		                   results.getContent().stream().map(ModelUtils::toDto).toList());
	}

	@Override
	public Optional<PrivilegeDto> getOptionalPrivilege(String functionality) {
		return privilegeRepository.findByFunctionality(functionality).map(ModelUtils::toDto);
	}

	@Override
	public void save(Privilege privilege) {
		privilegeRepository.save(privilege);
	}

	@Override
	public Optional<Privilege> optionalPrivilege(String functionality) {
		return privilegeRepository.findByFunctionality(functionality);
	}

	@Override
	public List<Privilege> findByRoleType(RoleType roleType) {
		return privilegeRepository.findAllByRoleType(roleType);
	}
}
