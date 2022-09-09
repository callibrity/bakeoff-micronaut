package com.callibrity.bakeoff;


import io.micronaut.core.annotation.Introspected;

@Introspected
public class CreateArtistRequest {

// ------------------------------ FIELDS ------------------------------

    private String name;
    private Genre genre;

// --------------------- GETTER / SETTER METHODS ---------------------

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
