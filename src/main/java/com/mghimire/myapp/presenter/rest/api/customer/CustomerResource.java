package com.mghimire.myapp.presenter.rest.api.customer;

import com.mghimire.myapp.presenter.rest.api.entities.ApiResponse;
import com.mghimire.myapp.presenter.rest.api.entities.CustomerRequest;
import com.mghimire.myapp.presenter.rest.api.entities.CustomerResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public interface CustomerResource {

  @GetMapping("/all")
  CompletableFuture<List<CustomerResponse>> getAllCustomers();

  @PostMapping("/create")
  CompletableFuture<ResponseEntity<ApiResponse>> createCustomer(@RequestBody CustomerRequest customerRequest);

  @GetMapping("/{phoneNumber}")
  CompletableFuture<CustomerResponse> getCustomerByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber);
}
