package com.example.SongLibraryApp.Song;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Singer.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SongService {
    public final SongRepository songRepository;
    public final SingerRepository singerRepository;
    @Autowired
    public SongService (SongRepository songRepository, SingerRepository singerRepository){
        this.songRepository = songRepository;
        this.singerRepository = singerRepository;
    }

    public Optional<Song> find(UUID id){
        return songRepository.findById(id);
    }

    public List<Song> findAll(){
        return songRepository.findAll();
    }

    public Optional<List<Song>> findAllBySinger(UUID singerId){
        return singerRepository.findById(singerId)
                .map(songRepository::findAllBySinger);
    }

    public void create(Song song){
        songRepository.save(song);
    }

    public void delete(UUID id){
        songRepository.findById(id).ifPresent(songRepository::delete);
    }
}
