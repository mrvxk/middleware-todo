package de.klein.ports.dto;

import de.klein.domain.ToDo;
import java.util.Collection;
import java.util.UUID;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Builder
public record UpdateTodoRequest(UUID id, String name, String notes, String priority) {

    public static TodoResourceMapper MAPPER = Mappers.getMapper(TodoResourceMapper.class);

    @Mapper
    public interface TodoResourceMapper {
        ToDo mapToEntity(final UpdateTodoRequest request);

        Collection<ToDo> mapToEntities(final Collection<UpdateTodoRequest> requests);
    }
}
