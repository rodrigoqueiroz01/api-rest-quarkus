package com.dev.controller;

import com.dev.dto.ProductDTO;
import com.dev.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("products")
public class ProductController {

    @Inject
    ProductService service;

    @GET
    @Produces(APPLICATION_JSON)
    public List<ProductDTO> findAll() {
        return service.getAllProducts();
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public ProductDTO findProductById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Response save(ProductDTO product) {
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
    public Response udpate(@PathParam("id") Long id, ProductDTO product) {
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
