package com.pristonit.cleanarchetecture.application.services.privileges;


import com.pristonit.cleanarchetecture.domain.users.Privilege;
import com.pristonit.cleanarchetecture.domain.users.RoleType;
import java.util.List;
import java.util.Optional;

public interface PrivilegeService {

	void save(Privilege privilege);
	Optional<Privilege> optionalPrivilege(String functionality);

	List<Privilege> findByRoleType(RoleType roleType);

}
