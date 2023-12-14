package com.example.songlibraryapp.song.function;

import com.example.songlibraryapp.song.dto.PatchSongRequest;
import com.example.songlibraryapp.song.entity.Song;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateSongWithRequestFunction implements BiFunction<Song, PatchSongRequest, Song> {
    @Override
    public Song apply(Song entity, PatchSongRequest request) {
        return Song.builder()
                .id(entity.getId())
                .name(request.getName())
                .year(request.getReleaseYear())
                .build();
    }
}
