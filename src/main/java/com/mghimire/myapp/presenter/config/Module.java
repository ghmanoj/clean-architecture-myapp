package com.mghimire.myapp.presenter.config;

import com.mghimire.myapp.core.usecases.customer.CreateCustomerUseCase;
import com.mghimire.myapp.core.usecases.customer.CustomerRepository;
import com.mghimire.myapp.core.usecases.customer.DeleteCustomerUseCase;
import com.mghimire.myapp.core.usecases.customer.GetAllCustomersUseCase;
import com.mghimire.myapp.core.usecases.customer.GetCustomerByPhoneNumberUseCase;
import com.mghimire.myapp.core.usecases.customer.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Module {

  @Bean
  public CreateCustomerUseCase createCustomerUseCase(CustomerRepository repository) {
    return new CreateCustomerUseCase(repository);
  }

  @Bean
  public GetCustomerByPhoneNumberUseCase getCustomerByPhoneNumberUseCase(
    CustomerRepository repository) {
    return new GetCustomerByPhoneNumberUseCase(repository);
  }

  @Bean
  public GetAllCustomersUseCase getAllCustomersUseCase(CustomerRepository repository) {
    return new GetAllCustomersUseCase(repository);
  }

  @Bean
  public DeleteCustomerUseCase deleteCustomerUseCase(CustomerRepository repository) {
    return new DeleteCustomerUseCase(repository);
  }

  @Bean
  public UpdateCustomerUseCase updateCustomerUseCase(CustomerRepository repository) {
    return new UpdateCustomerUseCase(repository);
  }
}
