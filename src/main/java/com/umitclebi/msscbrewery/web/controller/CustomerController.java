package com.umitclebi.msscbrewery.web.controller;

import com.umitclebi.msscbrewery.services.CustomerService;
import com.umitclebi.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Validated
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomerById(@NotNull @PathVariable("customerId")  UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> handlePost(@Valid @NotNull @RequestBody CustomerDto customerDto){
        CustomerDto savedCustomerDto=customerService.saveNewCustomerDto(customerDto);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Location","/api/v1/customer"+savedCustomerDto.getId().toString());
        return new ResponseEntity<>(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> handleUpdate(@PathVariable("customerId") UUID customerId,@Valid @NotNull @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteById(customerId);
    }
}
