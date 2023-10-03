package com.pristonit.cleanarchetecture.infra.repositories.privileges;

import com.pristonit.cleanarchetecture.domain.users.Privilege;
import com.pristonit.cleanarchetecture.domain.users.RoleType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

	Optional<Privilege> findByFunctionality(String functionality);

	List<Privilege> findAllByRoleType(RoleType roleType);
}
