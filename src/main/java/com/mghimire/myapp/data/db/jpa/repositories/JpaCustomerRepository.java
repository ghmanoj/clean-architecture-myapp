package com.mghimire.myapp.data.db.jpa.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mghimire.myapp.data.db.jpa.entities.CustomerEntity;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, Long> {

  Optional<CustomerEntity> findByPhoneNumber(String phoneNumber);

  boolean existsByPhoneNumber(String phoneNumber);
}
