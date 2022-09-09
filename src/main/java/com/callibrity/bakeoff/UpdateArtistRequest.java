package com.callibrity.bakeoff;

import lombok.Data;

@Data
public class UpdateArtistRequest {
    private String name;
    private Genre genre;
}
