package com.mghimire.myapp.presenter.rest.api.entities;

import com.mghimire.myapp.core.domain.Customer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerResponse {

  private final String phoneNumber;
  private final String email;
  private final String name;
  private final LocalDateTime responseTime;

  public CustomerResponse(String phoneNumber, String email, String name) {
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.name = name;
    this.responseTime = LocalDateTime.now();
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public LocalDateTime getResponseTime() {
    return responseTime;
  }

  public static CustomerResponse from(Customer customer) {
    return new CustomerResponse(
      customer.getPhoneNumber(),
      customer.getEmail(),
      customer.getName()
    );
  }

  public static List<CustomerResponse> from(List<Customer> customers) {
    return customers.parallelStream()
      .map(CustomerResponse::from)
      .collect(Collectors.toList());
  }
}
