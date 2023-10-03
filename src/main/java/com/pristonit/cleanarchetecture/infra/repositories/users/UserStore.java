package com.pristonit.cleanarchetecture.infra.repositories.users;


import com.pristonit.cleanarchetecture.application.services.users.UserQueryService;
import com.pristonit.cleanarchetecture.application.services.users.UserService;
import com.pristonit.cleanarchetecture.application.usecases.EPage;
import com.pristonit.cleanarchetecture.application.usecases.FilterPageRequest;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserRequestDto;
import com.pristonit.cleanarchetecture.application.usecases.utils.ModelUtils;
import com.pristonit.cleanarchetecture.domain.users.RoleType;
import com.pristonit.cleanarchetecture.domain.users.User;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.ModelUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class UserStore implements UserService, UserQueryService {


	UserRepository userRepository;

	@Autowired
	public UserStore(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<UserRequestDto> optionalUser(String email) {
		return userRepository.findUserByEmail(email).map(ModelUtils::toDto);
	}

	@Override
	public EPage<UserRequestDto> getAllUsers(FilterPageRequest pageRequest, RoleType roleType) {
		PageRequest pageable = PageRequest.of(pageRequest.page(), pageRequest.size(),
		                                      Sort.by("createdAt").descending());
		Page<User> results = null;
		if (roleType != null) {
			results = userRepository.findAll(pageable);
		} else {
			results = userRepository.findAll(pageable);
		}


		return new EPage<>(results.getPageable().getPageNumber(), results.getPageable().getPageSize(),
		                   results.getTotalPages(), results.getContent().stream().map(ModelUtils::toDto).toList());
	}

	@Override
	public void saveUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);

	}

	@Override
	public Optional<User> getOptionalUser(String email) {
		return userRepository.findUserByEmail(email);
	}
}
