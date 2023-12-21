package de.klein.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString
public class ToDo extends EntityParent {
    private String name;
    private String notes;
    private String priority;

    public void update(final ToDo externalTodo) {
        this.name = externalTodo.getName();
        this.notes = externalTodo.getNotes();
        this.priority = externalTodo.getPriority();
    }
}
