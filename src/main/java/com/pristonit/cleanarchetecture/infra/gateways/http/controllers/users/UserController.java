package com.pristonit.cleanarchetecture.infra.gateways.http.controllers.users;

import com.pristonit.cleanarchetecture.application.usecases.users.CreateUpdateUserUseCases;
import com.pristonit.cleanarchetecture.application.usecases.users.QueryUserUseCases;
import com.pristonit.cleanarchetecture.application.usecases.users.dtos.UserResponseDto;
import com.pristonit.cleanarchetecture.domain.users.RoleType;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.BaseResponse;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.ModelUtil;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.PageInfo;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.PageResponse;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.users.CreateUserRequest;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.users.FetchUserRequest;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.users.UpdateUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "v1/users")
@Tag(name = "User Controller", description = "RESTful API for managing users")
public class UserController {

	public static final String SUCCESS = "Success";
	CreateUpdateUserUseCases createUpdateUserUseCases;
	QueryUserUseCases queryUserUseCases;

	@Autowired
	public UserController(CreateUpdateUserUseCases createUpdateUserUseCases,
	                      QueryUserUseCases queryUserUseCases) {
		this.createUpdateUserUseCases = createUpdateUserUseCases;
		this.queryUserUseCases = queryUserUseCases;
	}

	@PostMapping
	@Operation(summary = "Create User", description = "Create a user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success")
	})
	public BaseResponse<UserResponseDto> createUser(@RequestBody CreateUserRequest request) {
		var res = createUpdateUserUseCases.createUser(ModelUtil.toDto(request));
		return BaseResponse.success(SUCCESS, res);
	}

	@PutMapping(path = {"/{email}"})
	@Operation(summary = "Update User details", description = "Update a user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success")
	})
	public BaseResponse<UserResponseDto> updateUser(@PathVariable(value = "email") String email,
	                                                @RequestBody UpdateUserRequest request) {
		var res = createUpdateUserUseCases.updateUser(email, ModelUtil.toDto(request));
		return BaseResponse.success(SUCCESS, res);
	}

	@GetMapping
	@Operation(summary = "Get Users", description = "Get a list of users")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success")
	})
	public PageResponse<FetchUserRequest> getUsers(@RequestParam(value = "size", required = false, defaultValue = "20") int size,
	                                               @RequestParam(value = "page", required = false, defaultValue = "0") int page,
	                                               @RequestParam(value = "roleType", required = false) RoleType roleType) {
		var res = queryUserUseCases.getUsers(size, page, roleType);
		return PageResponse.success(res.items().stream().map(ModelUtil::toDto).toList(),
		                            new PageInfo(res.page(), res.totalPages(),
		                                         res.items().size(), res.size(), res.requestedSize()));
	}

	@GetMapping(path = "/{email}")
	@Operation(summary = "Get a User Details", description = "Get a User Details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success")
	})
	public BaseResponse<FetchUserRequest> getUser(@PathVariable(value = "email") String email) {
		var res = queryUserUseCases.getUser(email);
		return BaseResponse.success(SUCCESS, ModelUtil.toDto(res));
	}
}
