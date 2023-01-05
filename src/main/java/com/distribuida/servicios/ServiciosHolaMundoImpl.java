package com.distribuida.servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.time.LocalDateTime;

@ApplicationScoped
public class ServiciosHolaMundoImpl implements ServicioHolaMundo {

    public String hola(){
        return "Hola "+ LocalDateTime.now();
    }
}
