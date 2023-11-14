package com.example.SongLibraryApp.Singer.function;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Singer.dto.GetSingerResponse;
import com.example.SongLibraryApp.Singer.dto.PutSingerRequest;
import com.example.SongLibraryApp.Song.Song;
import com.example.SongLibraryApp.Song.dto.GetSongResponse;
import com.example.SongLibraryApp.Song.dto.PutSongRequest;

import java.util.UUID;
import java.util.function.BiFunction;

public class RequestToSingerFunction implements BiFunction<UUID, PutSingerRequest, Singer> {
    @Override
    public Singer apply(UUID id, PutSingerRequest request) {
        return Singer.builder()
                .id(id)
                .name(request.getName())
                .age(request.getAge())
                .build();
    }
}
