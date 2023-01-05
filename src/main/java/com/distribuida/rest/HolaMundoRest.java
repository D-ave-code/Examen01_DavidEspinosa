package com.distribuida.rest;

import com.distribuida.servicios.ServicioHolaMundo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.LocalDateTime;

@ApplicationScoped
@Path(value="/")
public class HolaMundoRest {

    @Inject
    private ServicioHolaMundo service;

    @GET
    @Path("/hola")
    public String hola(){
        return service.hola();
    }
}
