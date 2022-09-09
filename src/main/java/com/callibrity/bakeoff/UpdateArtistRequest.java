package com.callibrity.bakeoff;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.ReflectiveAccess;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Introspected
@ReflectiveAccess
public record UpdateArtistRequest(@NotEmpty String name, @NotNull Genre genre) {

}
