package com.callibrity.bakeoff;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/api/artists")
public class ArtistsController {

// ------------------------------ FIELDS ------------------------------

    @Inject
    private ArtistService service;

// -------------------------- OTHER METHODS --------------------------

    @Post(consumes = "application/json")
    public Artist create(@Body CreateArtistRequest request) {
        return service.createArtist(request.getName(), request.getGenre());
    }

    @Delete("/{id}")
    public void delete(@PathVariable("id") String id) {
        service.deleteArtistById(id);
    }

    @Get("/{id}")
    public Artist get(@PathVariable("id") String id) {
        return service.findArtistById(id)
                .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, "Artist not found."));
    }

    @Get
    public List<Artist> list() {
        return service.listAllArtists();
    }

    @Put(value = "/{id}", consumes = "application/json")
    public Artist update(@PathVariable("id") String id, @Body UpdateArtistRequest request) {
        return service.updateArtist(id, request.getName(), request.getGenre())
                .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, "Artist not found."));
    }

}
