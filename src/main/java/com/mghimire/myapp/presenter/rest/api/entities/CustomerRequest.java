package com.mghimire.myapp.presenter.rest.api.entities;

public class CustomerRequest {

  private String phoneNumber;
  private String name;
  private String email;

  public CustomerRequest() {
  }

  public CustomerRequest(String phoneNumber, String name, String email) {
    this.phoneNumber = phoneNumber;
    this.name = name;
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "CustomerRequest{" +
      "phoneNumber='" + phoneNumber + '\'' +
      ", name='" + name + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
}
