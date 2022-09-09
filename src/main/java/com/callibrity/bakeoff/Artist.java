package com.callibrity.bakeoff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Introspected
public class Artist {

// ------------------------------ FIELDS ------------------------------

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Version
    @JsonIgnore
    private Long version;

// --------------------- GETTER / SETTER METHODS ---------------------

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

// ------------------------ CANONICAL METHODS ------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id.equals(artist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
