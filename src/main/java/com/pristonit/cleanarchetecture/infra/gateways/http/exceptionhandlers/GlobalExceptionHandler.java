package com.pristonit.cleanarchetecture.infra.gateways.http.exceptionhandlers;

import com.pristonit.cleanarchetecture.application.usecases.exceptions.privileges.NoSuchPrivilegeFoundException;
import com.pristonit.cleanarchetecture.application.usecases.exceptions.privileges.PrivilegeExistException;
import com.pristonit.cleanarchetecture.application.usecases.exceptions.users.NoSuchUserFoundException;
import com.pristonit.cleanarchetecture.application.usecases.exceptions.users.UserExistException;
import com.pristonit.cleanarchetecture.infra.gateways.http.models.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoSuchUserFoundException.class)
	public <T> ResponseEntity<BaseResponse<T>> mapException(NoSuchUserFoundException x) {
		String message = String.format("User %s does not exist", x.getEmail());
		BaseResponse<T> baseResponse = new BaseResponse<>(message, null, false);
		return new ResponseEntity<>(baseResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserExistException.class)
	public <T> ResponseEntity<BaseResponse<T>> mapException(UserExistException x) {
		String message = String.format("User %s already exist", x.getEmail());
		BaseResponse<T> baseResponse = new BaseResponse<>(message, null, false);
		return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchPrivilegeFoundException.class)
	public <T> ResponseEntity<BaseResponse<T>> mapException(NoSuchPrivilegeFoundException x) {
		String message = String.format("Privilege %s does not exist", x.getPrivilege());
		BaseResponse<T> baseResponse = new BaseResponse<>(message, null, false);
		return new ResponseEntity<>(baseResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PrivilegeExistException.class)
	public <T> ResponseEntity<BaseResponse<T>> mapException(PrivilegeExistException x) {
		String message = String.format("Privilege %s already exist", x.getPrivilege());
		BaseResponse<T> baseResponse = new BaseResponse<>(message, null, false);
		return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
	}



}
