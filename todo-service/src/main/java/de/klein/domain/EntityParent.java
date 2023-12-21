package de.klein.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@MappedSuperclass
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public abstract class EntityParent extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    @Setter(AccessLevel.PRIVATE)
    private UUID id;
}
