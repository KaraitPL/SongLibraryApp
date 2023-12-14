package com.example.songlibraryapp.singer.function;

import com.example.songlibraryapp.singer.dto.GetSingerResponse;
import com.example.songlibraryapp.singer.entity.Singer;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
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
