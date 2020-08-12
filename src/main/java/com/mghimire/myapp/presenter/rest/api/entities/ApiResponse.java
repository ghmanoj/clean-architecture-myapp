package com.mghimire.myapp.presenter.rest.api.entities;

import com.mghimire.myapp.core.domain.Customer;
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

  public static ResponseEntity<ApiResponse> from(Customer customer) {
    String phoneNumber = customer.getPhoneNumber();
    return ResponseEntity.ok(new ApiResponse(
        true,
        "Customer with phone number " + phoneNumber + " created"
    ));
  }
}
