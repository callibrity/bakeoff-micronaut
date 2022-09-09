package com.callibrity.bakeoff;

import lombok.Data;

@Data
public class CreateArtistRequest {
    private String name;
    private Genre genre;
}
