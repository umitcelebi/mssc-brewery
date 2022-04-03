package com.umitclebi.msscbrewery.web.mappers;

import com.umitclebi.msscbrewery.domain.Customer;
import com.umitclebi.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
