package com.asimkilic.loan.application.controller;

import com.asimkilic.loan.application.dto.customer.CustomerDto;
import com.asimkilic.loan.application.dto.customer.CustomerSaveRequestDto;
import com.asimkilic.loan.application.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "Customer Operations")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    @Operation(summary = "Returns all customers")
    public ResponseEntity<List<CustomerDto>> getAllUsers() {
        List<CustomerDto> customerDtoList = customerService.findAllUsers();
        return ResponseEntity.ok(customerDtoList);
    }

    @PostMapping
    @Operation(summary = "Saves new customer")
    public ResponseEntity<CustomerDto> saveNewCustomer(@RequestBody @Valid CustomerSaveRequestDto customerSaveRequestDto) {
        CustomerDto newCustomer = customerService.saveNewCustomer(customerSaveRequestDto);
        return ResponseEntity.ok(newCustomer);
    }
}