package com.example.SongLibraryApp.Song.function;

import com.example.SongLibraryApp.Song.Song;
import com.example.SongLibraryApp.Song.dto.PatchSongRequest;

import java.util.function.BiFunction;

public class UpdateSongWithRequestFunction implements BiFunction<Song, PatchSongRequest, Song> {
    @Override
    public Song apply(Song entity, PatchSongRequest request) {
        return Song.builder()
                .id(entity.getId())
                .name(entity.getName())
                .year(entity.getYear())
                .build();
    }
}
