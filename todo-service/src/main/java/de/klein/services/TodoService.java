package de.klein.services;

import de.klein.domain.ToDo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Slf4j
@ApplicationScoped
public class TodoService {

    public Collection<ToDo> getAll() {
        final List<ToDo> toDos = ToDo.listAll();
        log.info("Find all todo: {}", toDos);
        return toDos;
    }

    public void deleteById(final UUID id) {
        log.info("Delete todo: {}", id);
        ToDo.deleteById(id);
    }

    public ToDo create(final ToDo externalTodo) {
        externalTodo.persist();
        log.info("Create todo: {}", externalTodo);
        return externalTodo;
    }

    public ToDo update(final UUID id, final ToDo externalTodo) {
        log.info("Update todo: {}", externalTodo);
        final ToDo todo = ToDo.findById(id);
        todo.update(externalTodo);
        return todo;
    }
}
