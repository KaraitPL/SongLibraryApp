package com.example.SongLibraryApp.Song;

import com.example.SongLibraryApp.Singer.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SongService {
    public final SongRepository songRepository;
    @Autowired
    public SongService (SongRepository songRepository){this.songRepository = songRepository;}

    public List<Song> findAll(){
        return songRepository.findAll();
    }

    public void create(Song song){
        songRepository.save(song);
    }

    public void delete(UUID id){
        songRepository.findById(id).ifPresent(songRepository::delete);
    }
}
