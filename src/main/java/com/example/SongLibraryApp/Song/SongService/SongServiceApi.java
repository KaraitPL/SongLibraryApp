package com.example.SongLibraryApp.Song.SongService;

import com.example.SongLibraryApp.Song.Song;

import java.util.Optional;
import java.util.UUID;

public interface SongServiceApi {

    public Optional<Song> find(UUID id);
}
