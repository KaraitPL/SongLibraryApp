package com.example.SongLibraryApp.Singer;

import com.example.SongLibraryApp.Song.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class SingerService {

    public final SingerRepository singerRepository;
    @Autowired
    public SingerService(SingerRepository singerRepository){
        this.singerRepository = singerRepository;
    }

    public List<Singer> findAll(){
        return singerRepository.findAll();
    }

    public void create(Singer singer){
        singerRepository.save(singer);
    }

    public Optional<Singer> findById(UUID id) { return singerRepository.findById(id); }



}
