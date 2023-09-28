package com.pristonit.cleanarchetecture.infra.gateways.http.exceptionhandlers;

import com.pristonit.cleanarchetecture.application.usecases.exceptions.users.NoSuchUserFoundException;
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
}
