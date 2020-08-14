package com.mghimire.myapp.core.usecases.customer;

import com.mghimire.myapp.core.usecases.UseCase;
import com.mghimire.myapp.core.domain.Customer;
import com.mghimire.myapp.core.domain.PhoneNumberAlreadyUsedException;

public class CreateCustomerUseCase extends
  UseCase<CreateCustomerUseCase.InputValues, CreateCustomerUseCase.OutputValues> {

  private final CustomerRepository repository;

  public CreateCustomerUseCase(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public OutputValues execute(InputValues input) {
    String phoneNumber = input.getPhoneNumber();

    if (repository.existsByPhoneNumber(phoneNumber)) {
      throw new PhoneNumberAlreadyUsedException(
        String.format("Customer with phone number %s already exists", phoneNumber));
    }

    Customer customer = new Customer.Builder(phoneNumber)
      .setEmail(input.getEmail())
      .setName(input.getName())
      .build();

    return new OutputValues(repository.persist(customer));
  }

  public static class InputValues implements UseCase.InputValues {

    private final String phoneNumber;
    private final String name;
    private final String email;

    public InputValues(String phoneNumber, String name, String email) {
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
  }

  public static class OutputValues implements UseCase.OutputValues {

    private final Customer customer;

    public OutputValues(Customer customer) {
      this.customer = customer;
    }

    public Customer getCustomer() {
      return customer;
    }
  }

}
