package com.mghimire.myapp.core.usecases.customer;

import com.mghimire.myapp.core.domain.Customer;
import com.mghimire.myapp.core.domain.NotFoundException;
import com.mghimire.myapp.core.usecases.UseCase;
import java.util.Optional;

public class GetCustomerByPhoneNumberUseCase extends
    UseCase<GetCustomerByPhoneNumberUseCase.InputValues, GetCustomerByPhoneNumberUseCase.OutputValues> {

  private final CustomerRepository repository;

  public GetCustomerByPhoneNumberUseCase(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public OutputValues execute(InputValues input) {
    String phoneNumber = input.getPhoneNumber();

    Optional<Customer> customer = repository.getCustomerByPhoneNumber(phoneNumber);

    if (customer.isEmpty()) {
      throw new NotFoundException(
          String.format("Customer with phone number %s not found", phoneNumber)
      );
    }
    return new OutputValues(customer.get());
  }

  public static class InputValues implements UseCase.InputValues {
    private final String phoneNumber;
    public InputValues(String phoneNumber) {
      if (phoneNumber == null) throw new IllegalArgumentException("Phone number cannot be null");
      this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
      return phoneNumber;
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
