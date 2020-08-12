package com.mghimire.myapp.core.domain;

public abstract class DomainException extends RuntimeException {

  public DomainException(String message) {
    super(message);
  }

}
