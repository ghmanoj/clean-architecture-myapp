package com.mghimire.myapp.core.usecases.customer;

import java.util.List;
import com.mghimire.myapp.core.domain.Customer;
import java.util.Optional;

public interface CustomerRepository {

  Optional<Customer> getCustomerByPhoneNumber(String phoneNumber);

  List<Customer> getAllCustomers();

  boolean existsByPhoneNumber(String phoneNumber);

  Customer persist(Customer customer);

}
