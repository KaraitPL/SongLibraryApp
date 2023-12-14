package com.example.songlibraryapp.song.function;

import com.example.songlibraryapp.singer.entity.Singer;
import com.example.songlibraryapp.song.dto.PutSongRequest;
import com.example.songlibraryapp.song.entity.Song;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToSongFunction implements BiFunction<UUID, PutSongRequest, Song> {
    @Override
    public Song apply(UUID id, PutSongRequest request) {
        return Song.builder()
                .id(id)
                .name(request.getName())
                .year(request.getReleaseYear())
                .singer(Singer.builder()
                        .id(request.getSinger())
                        .build())
                .build();
    }
}
