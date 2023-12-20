package de.klein.ports;

import de.klein.domain.ToDo;
import de.klein.ports.dto.CreateTodoRequest;
import de.klein.ports.dto.TodoResource;
import de.klein.ports.dto.UpdateTodoRequest;
import de.klein.services.TodoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.UUID;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/todos")
public class TodoController {

    @Inject TodoService todoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<Collection<TodoResource>> getAll() {
        final Collection<TodoResource> todoResources =
                TodoResource.MAPPER.mapToResources(todoService.getAll());
        return RestResponse.ok(todoResources);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public RestResponse<Void> deleteById(@PathParam("id") final UUID id) {
        todoService.deleteById(id);
        return RestResponse.ok();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<TodoResource> create(final CreateTodoRequest request) {
        final ToDo toDo = todoService.create(CreateTodoRequest.MAPPER.mapToEntity(request));
        return RestResponse.ok(TodoResource.MAPPER.mapToResource(toDo));
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<TodoResource> update(final UpdateTodoRequest request) {
        final ToDo externalTodo = UpdateTodoRequest.MAPPER.mapToEntity(request);
        final ToDo internalTodo = todoService.update(externalTodo);
        return RestResponse.ok(TodoResource.MAPPER.mapToResource(internalTodo));
    }
}
