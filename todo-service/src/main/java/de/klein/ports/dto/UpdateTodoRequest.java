package de.klein.ports.dto;

import de.klein.domain.ToDo;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.UUID;

@Builder
public record UpdateTodoRequest(UUID id, String name, String notes, String priority) {

    public static TodoResourceMapper MAPPER = Mappers.getMapper(TodoResourceMapper.class);

    @Mapper
    public interface TodoResourceMapper {
        ToDo mapToEntity(final UpdateTodoRequest request);

        Collection<ToDo> mapToEntities(final Collection<UpdateTodoRequest> requests);
    }
}
