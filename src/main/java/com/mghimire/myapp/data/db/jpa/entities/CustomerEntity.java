package com.mghimire.myapp.data.db.jpa.entities;

import com.mghimire.myapp.core.domain.Customer;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "customer")
@Table(name = "customer")
public class CustomerEntity implements Serializable {

  private static final long serialVersionUID = -2907561599883694344L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "phone_number", unique = true, nullable = false)
  private String phoneNumber;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = true)
  private String email;

  public CustomerEntity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public static Customer fromThis(CustomerEntity customerEntity) {

    return new Customer.Builder(customerEntity.getPhoneNumber())
      .setEmail(customerEntity.getEmail())
      .setName(customerEntity.getName())
      .build();
  }

  public static CustomerEntity from(Customer customer) {
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setPhoneNumber(customer.getPhoneNumber());
    customerEntity.setName(customer.getName());
    customerEntity.setEmail(customer.getEmail());

    return customerEntity;
  }

}