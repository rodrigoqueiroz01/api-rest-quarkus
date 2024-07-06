package com.dev.client;

import com.dev.dto.CustomerDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("customers")
@RegisterRestClient
@ApplicationScoped
public interface CustomerClient {

    @GET
    @Path("/{id}")
    CustomerDTO findCustomerById(@PathParam("id") Long id);

}
