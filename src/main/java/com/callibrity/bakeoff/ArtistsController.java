package com.callibrity.bakeoff;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Inject;

import java.util.LinkedList;
import java.util.List;

@Controller("/api/artists")
public class ArtistsController {
    @Inject
    private ArtistRepository repository;

    @Get
    public List<Artist> list() {
        final List<Artist> artists = new LinkedList<>();
        repository.findAll().forEach(artists::add);
        return artists;
    }

    @Get("/{id}")
    public Artist get(@PathVariable("id") String id) {
        return repository.findById(id)
                .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, "Artist not found."));
    }

    @Post(consumes = "application/json")
    public Artist create(@Body CreateArtistRequest request) {
        final Artist artist = new Artist();
        artist.setName(request.getName());
        artist.setGenre(request.getGenre());
        repository.save(artist);
        return artist;
    }

    @Delete("/{id}")
    public void delete(@PathVariable("id") String id) {
        repository.deleteById(id);
    }

    @Put(value = "/{id}", consumes = "application/json")
    public Artist update(@PathVariable("id") String id, @Body UpdateArtistRequest request) {
        Artist artist = repository.findById(id)
                .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, "Artist not found."));
        artist.setName(request.getName());
        artist.setGenre(request.getGenre());
        repository.update(artist);
        return artist;
    }
}
