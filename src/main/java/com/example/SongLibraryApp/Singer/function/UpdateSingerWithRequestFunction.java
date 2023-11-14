package com.example.SongLibraryApp.Singer.function;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Singer.dto.PatchSingerRequest;


import java.util.function.BiFunction;

public class UpdateSingerWithRequestFunction implements BiFunction<Singer, PatchSingerRequest, Singer> {
    @Override
    public Singer apply(Singer entity, PatchSingerRequest request) {
        return Singer.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .build();
    }
}
