package com.example.SongLibraryApp.Song.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutSongRequest {
    private String name;
    private int releaseYear;
    private UUID singer;
}
