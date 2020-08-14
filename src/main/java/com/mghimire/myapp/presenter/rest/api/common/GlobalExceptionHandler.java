package com.mghimire.myapp.presenter.rest.api.common;

import com.mghimire.myapp.core.domain.NotFoundException;
import com.mghimire.myapp.core.domain.PhoneNumberAlreadyUsedException;
import com.mghimire.myapp.presenter.rest.api.entities.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {NotFoundException.class})
  ResponseEntity<ApiResponse> handleCustomerNotFoundException(NotFoundException ex) {
    return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {PhoneNumberAlreadyUsedException.class})
  ResponseEntity<ApiResponse> handlePhoneNumberAlreadyUsedException(
    PhoneNumberAlreadyUsedException ex) {
    return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.BAD_REQUEST);
  }

}
