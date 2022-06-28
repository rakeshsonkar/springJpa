package com.springJpa.springJpa.ControllerAdvisors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springJpa.springJpa.constants.ErrorCode;
import com.springJpa.springJpa.model.responses.ApiResponse;
import com.springJpa.springJpa.model.responses.Error;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalContollerAdvisor {
	@ExceptionHandler(value= {
			Exception.class
	})
	public ResponseEntity<ApiResponse<Void>> handleGenericException(final Exception e){
		log.error("error",e);
		final Error error=Error.create(ErrorCode.INTERNAL_SERVER_ERROR,"some went wrong");
		return ResponseEntity.internalServerError().body(ApiResponse.error(error));
	}

}
