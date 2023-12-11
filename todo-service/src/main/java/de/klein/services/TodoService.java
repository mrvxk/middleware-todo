package de.klein.services;

import de.klein.domain.ToDo;
import de.klein.ports.dto.CreateTodoRequest;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.UUID;
import org.jboss.resteasy.reactive.common.NotImplementedYet;

@ApplicationScoped
public class TodoService {

    public Collection<ToDo> getAll() {
        throw new NotImplementedYet();
    }

    public void deleteById(final UUID id) {
        throw new NotImplementedYet();
    }

    public ToDo create(final CreateTodoRequest request) {
        throw new NotImplementedYet();
    }
}
