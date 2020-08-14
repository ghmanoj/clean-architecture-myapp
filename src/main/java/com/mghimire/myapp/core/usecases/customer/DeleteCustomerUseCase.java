package com.mghimire.myapp.core.usecases.customer;

import com.mghimire.myapp.core.domain.Customer;
import com.mghimire.myapp.core.domain.NotFoundException;
import com.mghimire.myapp.core.usecases.UseCase;

public class DeleteCustomerUseCase extends
  UseCase<DeleteCustomerUseCase.InputValues, DeleteCustomerUseCase.OutputValues> {

  private final CustomerRepository repository;

  public DeleteCustomerUseCase(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public OutputValues execute(InputValues input) {
    String phoneNumber = input.getPhoneNumber();

    if (!repository.existsByPhoneNumber(phoneNumber))
      throw new NotFoundException("Customer with phone number " + phoneNumber + " not found");

    Customer deletedCustomer = repository.delete(phoneNumber);
    return new OutputValues(deletedCustomer);
  }

  public static class InputValues implements UseCase.InputValues {
    private final String phoneNumber;

    public InputValues(String phoneNumber) {
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
