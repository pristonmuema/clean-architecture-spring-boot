package com.pristonit.cleanarchetecture.application.services.users;


import com.pristonit.cleanarchetecture.domain.users.User;
import java.util.Optional;

public interface UserService {

	void saveUser(User user);
	void updateUser(User user);
	Optional<User> getOptionalUser(String email);

}
