package de.klein.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString
public class ToDo extends EntityParent {
    @Column(name = "NAME")
    private String name;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "PRIO")
    private String priority;

    public void update(final ToDo externalTodo) {
        this.name = externalTodo.getName();
        this.notes = externalTodo.getNotes();
        this.priority = externalTodo.getPriority();
    }
}
