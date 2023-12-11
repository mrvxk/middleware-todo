package de.klein.ports.dto;

import de.klein.domain.ToDo;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Builder
public record CreateTodoRequest(String name, String notes, String priority) {

    public static CreateTodoRequestMapper MAPPER = Mappers.getMapper(CreateTodoRequestMapper.class);

    @Mapper
    public interface CreateTodoRequestMapper {
        ToDo mapToEntity(final CreateTodoRequest toDo);
    }
}
