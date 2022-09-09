package com.callibrity.bakeoff;

import io.micronaut.core.annotation.Introspected;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;
@Data
@EqualsAndHashCode(of="id")
@Entity
@Introspected
public class Artist {

// ------------------------------ FIELDS ------------------------------

    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id = UUID.randomUUID().toString();

    @NotEmpty
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Genre genre;

}
