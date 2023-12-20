package de.klein.domain;

import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public abstract class EntityParent {

    @Setter @EqualsAndHashCode.Include private UUID id;
}
