package com.pristonit.cleanarchetecture.infra.repositories.users;

import com.pristonit.cleanarchetecture.domain.users.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

	Privilege findAllByFunctionality(String functionality);
}
