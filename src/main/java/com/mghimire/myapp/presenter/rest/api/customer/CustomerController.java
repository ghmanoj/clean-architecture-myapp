package com.mghimire.myapp.presenter.rest.api.customer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.mghimire.myapp.core.usecases.UseCaseExecutor;
import com.mghimire.myapp.core.usecases.customer.CreateCustomerUseCase;
import com.mghimire.myapp.core.usecases.customer.DeleteCustomerUseCase;
import com.mghimire.myapp.core.usecases.customer.GetAllCustomersUseCase;
import com.mghimire.myapp.core.usecases.customer.GetCustomerByPhoneNumberUseCase;
import com.mghimire.myapp.presenter.rest.api.entities.ApiResponse;
import com.mghimire.myapp.presenter.rest.api.entities.CustomerRequest;
import com.mghimire.myapp.presenter.rest.api.entities.CustomerResponse;

@Component
public class CustomerController implements CustomerResource {

  private final GetAllCustomersUseCase getAllCustomersUseCase;
  private final GetCustomerByPhoneNumberUseCase getCustomerByPhoneNumberUseCase;
  private final CreateCustomerUseCase createCustomerUseCase;
  private final DeleteCustomerUseCase deleteCustomerUseCase;

  private final UseCaseExecutor useCaseExecutor;

  public CustomerController(
    UseCaseExecutor useCaseExecutor,
    GetAllCustomersUseCase getAllCustomersUseCase,
    GetCustomerByPhoneNumberUseCase getCustomerByPhoneNumberUseCase,
    CreateCustomerUseCase createCustomerUseCase,
    DeleteCustomerUseCase deleteCustomerUseCase) {

    this.useCaseExecutor = useCaseExecutor;

    this.getAllCustomersUseCase = getAllCustomersUseCase;
    this.getCustomerByPhoneNumberUseCase = getCustomerByPhoneNumberUseCase;
    this.createCustomerUseCase = createCustomerUseCase;
    this.deleteCustomerUseCase = deleteCustomerUseCase;
  }

  @Override
  public CompletableFuture<List<CustomerResponse>> getAllCustomers() {
    return useCaseExecutor.execute(
      getAllCustomersUseCase,
      new GetAllCustomersUseCase.InputValues(),
      outputValues -> CustomerResponse.from(outputValues.getCustomerList())
    );
  }

  @Override
  public CompletableFuture<ResponseEntity<ApiResponse>> createCustomer(
    CustomerRequest customerRequest) {
    return useCaseExecutor.execute(
      createCustomerUseCase,
      new CreateCustomerUseCase.InputValues(
        customerRequest.getPhoneNumber(),
        customerRequest.getName(),
        customerRequest.getEmail()
      ),
      outputValues -> ApiResponse.from("Customer with phone number " + outputValues.getCustomer().getPhoneNumber() + " created")
    );
  }

  @Override
  public CompletableFuture<CustomerResponse> getCustomerByPhoneNumber(String phoneNumber) {
    return useCaseExecutor.execute(
      getCustomerByPhoneNumberUseCase,
      new GetCustomerByPhoneNumberUseCase.InputValues(phoneNumber),
      outputValues -> CustomerResponse.from(outputValues.getCustomer())
    );
  }

  @Override
  public CompletableFuture<ResponseEntity<ApiResponse>> deleteCustomer(String phoneNumber) {
    return useCaseExecutor.execute(
      deleteCustomerUseCase,
      new DeleteCustomerUseCase.InputValues(phoneNumber),
      outputValues -> ApiResponse.from("Customer with phone number " + outputValues.getCustomer().getPhoneNumber() + " deleted")
    );
  }
}
