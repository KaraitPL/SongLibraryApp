package com.example.SongLibraryApp.Song.function;

import com.example.SongLibraryApp.Song.Song;
import com.example.SongLibraryApp.Song.dto.GetSongResponse;
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
