package com.dev.controller;

import com.dev.dto.OrderDTO;
import com.dev.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("orders")
public class OrderController {

    @Inject
    OrderService service;

    @GET
    @Produces(APPLICATION_JSON)
    public List<OrderDTO> findAll() {
        return service.getAllOrders();
    }

    @POST
    public Response save(OrderDTO product) {
        try {
            service.save(product);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response udpate(@PathParam("id") Long id, OrderDTO product) {
        try {
            service.update(id, product);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(Long id) {
        try {
            service.delete(id);
            return Response.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
