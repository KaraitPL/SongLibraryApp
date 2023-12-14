package com.example.songlibraryapp.singer.function;

import com.example.songlibraryapp.singer.dto.GetSingersResponse;
import com.example.songlibraryapp.singer.entity.Singer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SingersToResponseFunction implements Function<List<Singer>, GetSingersResponse> {
    @Override
    public GetSingersResponse apply(List<Singer> entities) {
        return GetSingersResponse.builder()
                .singers(entities.stream()
                        .map(singer -> GetSingersResponse.Singer.builder()
                                .id(singer.getId())
                                .name(singer.getName())
                                .age(singer.getAge())
                                .build())
                        .toList())
                .build();
    }
}
