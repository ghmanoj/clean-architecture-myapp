package com.mghimire.myapp.core.domain;

public class PhoneNumberAlreadyUsedException extends DomainException {

  public PhoneNumberAlreadyUsedException(String message) {
    super(message);
  }

}
