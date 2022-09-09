package com.callibrity.bakeoff;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ArtistRepository extends CrudRepository<Artist,String> {
}
