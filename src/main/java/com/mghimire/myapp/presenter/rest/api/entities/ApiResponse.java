package com.mghimire.myapp.presenter.rest.api.entities;

import org.springframework.http.ResponseEntity;

public class ApiResponse {

  private final boolean success;
  private final String message;

  public ApiResponse(boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  public boolean isSuccess() {
    return success;
  }

  public String getMessage() {
    return message;
  }

  public static ResponseEntity<ApiResponse> from(String message) {
    return ResponseEntity.ok(new ApiResponse(true, message));
  }
}
