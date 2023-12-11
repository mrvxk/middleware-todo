package de.klein.ports.dto;

import de.klein.domain.ToDo;
import java.util.Collection;
import java.util.UUID;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Builder
public record TodoResource(UUID id, String name, String notes, String priority) {

    public static TodoResourceMapper MAPPER = Mappers.getMapper(TodoResourceMapper.class);

    @Mapper
    public interface TodoResourceMapper {
        TodoResource mapToResource(final ToDo toDo);

        Collection<TodoResource> mapToResources(final Collection<ToDo> toDos);
    }
}
