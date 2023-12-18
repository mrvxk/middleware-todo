package de.klein.services;

import de.klein.domain.ToDo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collection;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.common.NotImplementedYet;

@Slf4j
@ApplicationScoped
public class TodoService {

    public Collection<ToDo> getAll() {
        throw new NotImplementedYet();
    }

    public void deleteById(final UUID id) {
        throw new NotImplementedYet();
    }

    public ToDo create(final ToDo externalTodo) {
        log.info("Create todo: {}", externalTodo);
        throw new NotImplementedYet();
    }

    public ToDo update(final ToDo externalTodo) {
        log.info("Update todo: {}", externalTodo);
        throw new NotImplementedYet();
    }
}
