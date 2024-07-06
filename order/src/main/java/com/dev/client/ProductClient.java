package com.dev.client;

import com.dev.dto.ProductDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("products")
@RegisterRestClient
@ApplicationScoped
public interface ProductClient {

    @GET
    @Path("/{id}")
    ProductDTO findProductById(@PathParam("id") Long id);

}
