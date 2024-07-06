package com.dev.controller;

import com.dev.dto.CustomerDTO;
import com.dev.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("customers")
public class CustomerController {

    @Inject
    CustomerService service;

    @GET
    @Produces(APPLICATION_JSON)
    public List<CustomerDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public CustomerDTO findCustomerById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Transactional
    public Response save(CustomerDTO customerDTO) {
        try {
            service.createNewCustomer(customerDTO);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeCustomer(@PathParam("id") Long id, CustomerDTO customerDTO) {
        try {
            service.changeCustomer(id, customerDTO);
            return Response.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response changeCustomer(@PathParam("id") Long id) {
        try {
            service.deleteCustomer(id);
            return Response.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
