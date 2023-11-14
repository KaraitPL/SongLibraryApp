package com.example.SongLibraryApp.Singer.function;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Singer.dto.GetSingersResponse;

import java.util.List;
import java.util.function.Function;

public class SingersToResponseFunction implements Function<List<Singer>, GetSingersResponse> {
    @Override
    public GetSingersResponse apply(List<Singer> entities) {
        return GetSingersResponse.builder()
                .singers(entities.stream()
                        .map(singer -> GetSingersResponse.Singer.builder()
                                .id(singer.getId())
                                .name(singer.getName())
                                .build())
                        .toList())
                .build();
    }
}
