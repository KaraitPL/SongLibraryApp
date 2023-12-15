package com.example.songlibraryapp.song.function;

import com.example.songlibraryapp.song.dto.GetSongResponse;
import com.example.songlibraryapp.song.entity.Song;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SongToResponseFunction implements Function<Song, GetSongResponse> {
    @Override
    public GetSongResponse apply(Song entity) {
        return GetSongResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .releaseYear(entity.getYear())
                .singer(GetSongResponse.Singer.builder()
                        .id(entity.getSinger().getId())
                        .name(entity.getSinger().getName())
                        .age(entity.getSinger().getAge())
                        .build())
                .build();
    }
}
