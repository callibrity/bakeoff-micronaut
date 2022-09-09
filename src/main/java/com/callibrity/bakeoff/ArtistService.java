package com.callibrity.bakeoff;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class ArtistService {

// ------------------------------ FIELDS ------------------------------

    private final ArtistRepository repository;

// -------------------------- OTHER METHODS --------------------------

    @Transactional
    public Artist createArtist(String name, Genre genre) {
        final Artist artist = new Artist();
        artist.setName(name);
        artist.setGenre(genre);
        repository.save(artist);
        return artist;
    }

    @Transactional
    public void deleteArtistById(String id) {
        repository.deleteById(id);
    }

    public Optional<Artist> findArtistById(String id) {
        return repository.findById(id);
    }

    public List<Artist> listAllArtists() {
        final List<Artist> artists = new LinkedList<>();
        repository.findAll().forEach(artists::add);
        return artists;
    }

    @Transactional
    public Optional<Artist> updateArtist(String id, String name, Genre genre) {
        return repository.findById(id)
                .map(artist -> {
                    artist.setName(name);
                    artist.setGenre(genre);
                    return artist;
                });
    }

}
