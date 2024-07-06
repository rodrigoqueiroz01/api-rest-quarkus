package com.dev.mapper;

import com.dev.dto.CustomerDTO;
import com.dev.model.Customer;

public class CustomerMapper {

    public static CustomerDTO fromEntityToDTO(Customer customer) {
        return CustomerDTO.builder()
                .address(customer.getAddress())
                .age(customer.getAge())
                .email(customer.getEmail())
                .name(customer.getName())
                .phone(customer.getPhone())
                .build();
    }

    public static Customer fromDTOToEntity(CustomerDTO customerDTO) {
        return Customer.builder()
                .address(customerDTO.getAddress())
                .age(customerDTO.getAge())
                .email(customerDTO.getEmail())
                .name(customerDTO.getName())
                .phone(customerDTO.getPhone())
                .build();
    }

}
