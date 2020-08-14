package com.mghimire.myapp.core.usecases.customer;

import com.mghimire.myapp.core.domain.Customer;
import com.mghimire.myapp.core.usecases.UseCase;
import java.util.List;

public class GetAllCustomersUseCase extends
  UseCase<GetAllCustomersUseCase.InputValues, GetAllCustomersUseCase.OutputValues> {

  private final CustomerRepository repository;

  public GetAllCustomersUseCase(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public OutputValues execute(InputValues input) {
    return new OutputValues(repository.getAllCustomers());
  }

  public static class InputValues implements UseCase.InputValues {

  }

  public static class OutputValues implements UseCase.OutputValues {

    private final List<Customer> customerList;

    public OutputValues(List<Customer> customerList) {
      this.customerList = customerList;
    }

    public List<Customer> getCustomerList() {
      return customerList;
    }
  }

}
