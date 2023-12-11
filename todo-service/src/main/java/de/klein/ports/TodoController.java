package de.klein.ports;

import de.klein.ports.dto.TodoResource;
import de.klein.services.TodoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
    @Path("/delete/{id}")
    public RestResponse<Void> deleteById(final UUID id) {
        todoService.deleteById(id);
        return RestResponse.ok();
    }
}
