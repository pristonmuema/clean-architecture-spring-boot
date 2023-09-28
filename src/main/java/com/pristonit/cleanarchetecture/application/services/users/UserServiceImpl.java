package com.pristonit.cleanarchetecture.application.services.users;

import com.pristonit.cleanarchetecture.application.usecases.EPage;
import com.pristonit.cleanarchetecture.application.usecases.FilterPageRequest;
import com.pristonit.cleanarchetecture.application.usecases.utils.ModelUtil;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserRequestDto;
import com.pristonit.cleanarchetecture.domain.users.User;
import com.pristonit.cleanarchetecture.infra.repositories.users.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserQueryService {


	UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<UserRequestDto> optionalUser(String email) {
		return userRepository.findUserByEmail(email).map(ModelUtil::toDto);
	}

	@Override
	public EPage<UserRequestDto> getAllUsers(FilterPageRequest pageRequest, String privileges) {
		PageRequest pageable = PageRequest.of(pageRequest.page(), pageRequest.size(),
		                                      Sort.by("createdAt").ascending());
		Page<User> results = userRepository.findAll(pageable);

		return new EPage<>(results.getPageable().getPageNumber(), results.getPageable().getPageSize(),
		                   results.getTotalPages(), results.getContent().stream().map(ModelUtil::toDto).toList());
	}

	@Override
	public void saveUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public void updateUser(User user) {

	}

	@Override
	public Optional<User> getOptionalUser(String email) {
		return userRepository.findUserByEmail(email);
	}
}
