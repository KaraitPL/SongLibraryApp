package com.example.SongLibraryApp.Song.function;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Song.Song;
import com.example.SongLibraryApp.Song.dto.PutSongRequest;
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
