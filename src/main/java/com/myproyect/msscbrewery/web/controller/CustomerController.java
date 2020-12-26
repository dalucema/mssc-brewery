package com.myproyect.msscbrewery.web.controller;

import com.myproyect.msscbrewery.service.CustomerService;
import com.myproyect.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> handlePost(@RequestBody CustomerDto customerDto) {

        CustomerDto saveDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/customer/" + saveDto.getId().toString());
        //todo add hostname to url http://localhost:8090
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {

        customerService.updateNewCustomer(customerId, customerDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteById(customerId);
    }
}
