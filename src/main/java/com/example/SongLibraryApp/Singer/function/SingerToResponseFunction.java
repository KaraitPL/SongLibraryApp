package com.example.SongLibraryApp.Singer.function;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Singer.dto.GetSingerResponse;
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
