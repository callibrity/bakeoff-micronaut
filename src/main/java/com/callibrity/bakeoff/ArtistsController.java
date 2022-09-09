package com.callibrity.bakeoff;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ExecuteOn(TaskExecutors.IO)
@Controller("/api/artists")
@RequiredArgsConstructor
public class ArtistsController {

// ------------------------------ FIELDS ------------------------------

    private final ArtistService service;

// -------------------------- OTHER METHODS --------------------------

    @Post(consumes = "application/json")
    public Artist create(@Body CreateArtistRequest request) {
        return service.createArtist(request.name(), request.genre());
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
        return service.updateArtist(id, request.name(), request.genre())
                .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, "Artist not found."));
    }

}
