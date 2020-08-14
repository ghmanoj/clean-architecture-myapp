package com.mghimire.myapp.data.db.jpa.repositories;

import com.mghimire.myapp.core.domain.Customer;
import com.mghimire.myapp.core.usecases.customer.CustomerRepository;
import com.mghimire.myapp.data.db.jpa.entities.CustomerEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

  private final JpaCustomerRepository jpaRepository;

  public CustomerRepositoryImpl(JpaCustomerRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public Optional<Customer> getCustomerByPhoneNumber(String phoneNumber) {
    return jpaRepository.findByPhoneNumber(phoneNumber).map(CustomerEntity::fromThis);
  }

  @Override
  public List<Customer> getAllCustomers() {
    return jpaRepository.findAll()
      .stream()
      .map(CustomerEntity::fromThis)
      .collect(Collectors.toList());
  }

  @Override
  public boolean existsByPhoneNumber(String phoneNumber) {
    return jpaRepository.existsByPhoneNumber(phoneNumber);
  }

  @Override
  public Customer persist(Customer customer) {
    CustomerEntity customerEntity = CustomerEntity.from(customer);
    CustomerEntity savedCustomerEntity = jpaRepository.save(customerEntity);
    return CustomerEntity.fromThis(savedCustomerEntity);
  }

  @Override
  public Customer delete(String phoneNumber) {
    CustomerEntity customerEntity = jpaRepository.findByPhoneNumber(phoneNumber).orElseThrow();
    jpaRepository.delete(customerEntity);
    return CustomerEntity.fromThis(customerEntity);
  }

  @Override
  public Customer update(Customer customer) {
    CustomerEntity customerEntity = jpaRepository.findByPhoneNumber(customer.getPhoneNumber()).orElseThrow();
    customerEntity.setEmail(customer.getEmail());
    customerEntity.setName(customer.getName());

    CustomerEntity savedEntity = jpaRepository.save(customerEntity);

    return CustomerEntity.fromThis(savedEntity);
  }
}
