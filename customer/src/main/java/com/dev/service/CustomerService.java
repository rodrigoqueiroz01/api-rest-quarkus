package com.dev.service;

import com.dev.dto.CustomerDTO;
import com.dev.repository.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

import static com.dev.mapper.CustomerMapper.*;

@ApplicationScoped
@AllArgsConstructor
public class CustomerService {

    @Inject
    private CustomerRepository repository;

    public List<CustomerDTO> findAll() {
        List<CustomerDTO> customers = new ArrayList<>();

        repository.findAll().stream().forEach(item -> {
            customers.add(fromEntityToDTO(item));
        });

        return customers;
    }

    public CustomerDTO findById(Long id) {
        return fromEntityToDTO(repository.findById(id));
    }

    public void createNewCustomer(CustomerDTO customerDTO) {
        repository.persist(fromDTOToEntity(customerDTO));
    }

    public void changeCustomer(Long id, CustomerDTO customerDTO) {
        var customer = repository.findById(id);
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());
        customer.setEmail(customerDTO.getEmail());
        customer.setAge(customer.getAge());

        repository.persist(customer);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

}
