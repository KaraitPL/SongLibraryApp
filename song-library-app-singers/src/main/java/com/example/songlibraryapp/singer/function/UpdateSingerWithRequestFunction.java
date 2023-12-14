package com.example.songlibraryapp.singer.function;

import com.example.songlibraryapp.singer.dto.PatchSingerRequest;
import com.example.songlibraryapp.singer.entity.Singer;
import org.springframework.stereotype.Component;


import java.util.function.BiFunction;

@Component
public class UpdateSingerWithRequestFunction implements BiFunction<Singer, PatchSingerRequest, Singer> {
    @Override
    public Singer apply(Singer entity, PatchSingerRequest request) {
        return Singer.builder()
                .id(entity.getId())
                .name(request.getName())
                .age(request.getAge())
                .build();
    }
}
