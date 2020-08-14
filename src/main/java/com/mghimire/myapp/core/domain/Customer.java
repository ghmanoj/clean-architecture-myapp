package com.mghimire.myapp.core.domain;

public class Customer {

  private final String phoneNumber;
  private final String name;
  private final String email;

  private Customer(String phoneNumber, String name, String email) {
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

  public static class Builder {

    private final String phoneNumber;
    private String email;
    private String name;

    public Builder(String phoneNumber) {
      if (phoneNumber == null) {
        throw new IllegalArgumentException("Phone number cannot be empty");
      }

      this.phoneNumber = phoneNumber;
    }

    public Builder setEmail(String email) {
      this.email = email;
      return this;
    }

    public Builder setName(String name) {
      if (name == null) {
        throw new IllegalArgumentException("Name cannot be empty");
      }

      this.name = name;
      return this;
    }

    public Customer build() {
      return new Customer(phoneNumber, email, name);
    }
  }
}
