package com.pristonit.cleanarchetecture.infra.gateways.http.controllers.privileges;


import com.pristonit.cleanarchetecture.application.usecases.privileges.CreateUpdatePrivilegeUseCase;
import com.pristonit.cleanarchetecture.application.usecases.privileges.QueryPrivilegeUseCase;
import com.pristonit.cleanarchetecture.application.usecases.privileges.dtos.PrivilegeResponseDto;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.BaseResponse;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.ModelUtil;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.PageInfo;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.PageResponse;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.privileges.CreatePrivilegeRequest;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.privileges.PrivilegeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/privileges")
@Tag(name = "Privilege Controller", description = "RESTful API for managing user privileges")
public class PrivilegesController {

	public static final String SUCCESS = "Success";
	CreateUpdatePrivilegeUseCase createUpdatePrivilegeUseCase;
	QueryPrivilegeUseCase queryPrivilegeUseCase;

	@Autowired
	public PrivilegesController(CreateUpdatePrivilegeUseCase createUpdatePrivilegeUseCase,
	                            QueryPrivilegeUseCase queryPrivilegeUseCase) {
		this.createUpdatePrivilegeUseCase = createUpdatePrivilegeUseCase;
		this.queryPrivilegeUseCase = queryPrivilegeUseCase;
	}

	@PostMapping
	@Operation(summary = "Create privilege", description = "Create privilege")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success")
	})
	public BaseResponse<PrivilegeResponseDto> createPrivilege(
			@RequestBody CreatePrivilegeRequest request) {
		var res = createUpdatePrivilegeUseCase.createPrivilege(ModelUtil.toDto(request));
		return BaseResponse.success(SUCCESS, res);
	}

	@GetMapping(path = "/{privilege}")
	@Operation(summary = "Get a privilege", description = "Get a privilege")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success")
	})
	public BaseResponse<PrivilegeResponse> getPrivilege(
			@PathVariable(value = "privilege") String privilege) {
		var res = queryPrivilegeUseCase.getPrivilege(privilege);
		return BaseResponse.success(SUCCESS, ModelUtil.toDto(res));
	}

	@GetMapping
	@Operation(summary = "Get privileges", description = "Get privileges")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success")
	})
	public PageResponse<PrivilegeResponse> getPrivileges(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "20") int size) {
		var res = queryPrivilegeUseCase.getPrivileges(page, size);
		return PageResponse.success(res.items().stream().map(ModelUtil::toDto).toList(),
		                            new PageInfo(res.page(), res.totalPages(),
		                                         res.items().size(), res.size(), res.requestedSize()));
	}
}
