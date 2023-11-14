package com.example.SongLibraryApp.Singer.function;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Singer.dto.GetSingerResponse;

import java.util.function.Function;

public class SingerToResponseFunction implements Function<Singer, GetSingerResponse> {
    @Override
    public GetSingerResponse apply(Singer entity) {
        return GetSingerResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .build();
    }
}
