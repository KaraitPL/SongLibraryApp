package com.example.SongLibraryApp.Singer.function;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Singer.dto.PatchSingerRequest;
import org.springframework.stereotype.Component;


import java.util.function.BiFunction;

@Component
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
