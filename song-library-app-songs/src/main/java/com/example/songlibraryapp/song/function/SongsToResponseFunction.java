package com.example.songlibraryapp.song.function;

import com.example.songlibraryapp.song.dto.GetSongsResponse;
import com.example.songlibraryapp.song.entity.Song;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SongsToResponseFunction implements Function<List<Song>, GetSongsResponse> {
    @Override
    public GetSongsResponse apply(List<Song> entities) {
        return GetSongsResponse.builder()
                .songs(entities.stream()
                        .map(song -> GetSongsResponse.Song.builder()
                                .id(song.getId())
                                .name(song.getName())
                                .releaseYear(song.getYear())
                                .build())
                        .toList())
                .build();
    }
}
