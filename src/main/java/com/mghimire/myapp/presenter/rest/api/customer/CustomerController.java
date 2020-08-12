package com.mghimire.myapp.presenter.rest.api.customer;

import com.mghimire.myapp.core.usecases.UseCaseExecutor;
import com.mghimire.myapp.core.usecases.customer.CreateCustomerUseCase;
import com.mghimire.myapp.core.usecases.customer.GetAllCustomersUseCase;
import com.mghimire.myapp.core.usecases.customer.GetCustomerByPhoneNumberUseCase;
import com.mghimire.myapp.core.usecases.customer.GetCustomerByPhoneNumberUseCase.InputValues;
import com.mghimire.myapp.presenter.rest.api.entities.ApiResponse;
import com.mghimire.myapp.presenter.rest.api.entities.CustomerRequest;
import com.mghimire.myapp.presenter.rest.api.entities.CustomerResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class CustomerController implements CustomerResource {

  private final GetAllCustomersUseCase getAllCustomersUseCase;
  private final GetCustomerByPhoneNumberUseCase getCustomerByPhoneNumberUseCase;
  private final CreateCustomerUseCase createCustomerUseCase;
  private final UseCaseExecutor useCaseExecutor;

  public CustomerController(
      UseCaseExecutor useCaseExecutor,
      GetAllCustomersUseCase getAllCustomersUseCase,
      GetCustomerByPhoneNumberUseCase getCustomerByPhoneNumberUseCase,
      CreateCustomerUseCase createCustomerUseCase) {

    this.useCaseExecutor = useCaseExecutor;

    this.getAllCustomersUseCase = getAllCustomersUseCase;
    this.getCustomerByPhoneNumberUseCase = getCustomerByPhoneNumberUseCase;
    this.createCustomerUseCase = createCustomerUseCase;
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
  public CompletableFuture<ResponseEntity<ApiResponse>> createCustomer(CustomerRequest customerRequest) {
    return useCaseExecutor.execute(
        createCustomerUseCase,
        new CreateCustomerUseCase.InputValues(
            customerRequest.getPhoneNumber(),
            customerRequest.getName(),
            customerRequest.getEmail()
        ),
        outputValues -> ApiResponse.from(outputValues.getCustomer())
    );
  }

  @Override
  public CompletableFuture<CustomerResponse> getCustomerByPhoneNumber(String phoneNumber) {
    return useCaseExecutor.execute(
        getCustomerByPhoneNumberUseCase,
        new InputValues(phoneNumber),
        outputValues -> CustomerResponse.from(outputValues.getCustomer())
    );
  }

}
