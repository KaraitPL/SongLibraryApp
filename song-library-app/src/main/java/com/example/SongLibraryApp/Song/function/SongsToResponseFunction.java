package com.example.SongLibraryApp.Song.function;

import com.example.SongLibraryApp.Song.Song;
import com.example.SongLibraryApp.Song.dto.GetSongsResponse;
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
