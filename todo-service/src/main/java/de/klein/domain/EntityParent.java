package de.klein.domain;

import java.util.UUID;
import lombok.EqualsAndHashCode;

public abstract class EntityParent {

    @EqualsAndHashCode.Include private UUID id;
}
