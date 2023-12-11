package de.klein.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ToDo extends EntityParent {
    private String name;
    private String notes;
    private String priority;
}
