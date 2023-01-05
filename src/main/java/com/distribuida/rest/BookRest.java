package com.distribuida.rest;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/books")

public class BookRest {
    @Inject private BookService bookService;
@Inject private DbConfig dbConfig;
    @GET
    @Path("{id}")

    @Produces(MediaType.APPLICATION_JSON)
    public Response findBy(@PathParam("id") Integer id){

        return  Response.ok(bookService.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {

        return Response.ok(bookService.findAll()).status(Response.Status.CREATED).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Book book) {
        Book newBook = bookService.create(book);
        return Response.ok(newBook).status(Response.Status.CREATED).build();
    }
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, Book book) {
         book.setId(id);
        Book updatedBook = bookService.update(book);
        if (updatedBook == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedBook).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        bookService.delete(id);
        return Response.noContent().build();
    }


}
