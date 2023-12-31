package com.example.SongLibraryApp.Singer.dto;

import com.example.SongLibraryApp.Song.Song;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetSingerResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Song{
        private String name;
        private int releaseYear;

    }
    private UUID id;
    private String name;
    private int age;

    @Singular
    private List<Song> songs;
}
