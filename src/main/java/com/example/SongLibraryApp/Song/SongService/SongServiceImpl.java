package com.example.SongLibraryApp.Song.SongService;

import com.example.SongLibraryApp.Song.Song;
import com.example.SongLibraryApp.Song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class SongServiceImpl implements SongServiceApi{
    private final SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @Override
    public Optional<Song> find(UUID id){
        return songRepository.findById(id);
    }
}
