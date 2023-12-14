package com.example.songlibraryapp.singer.service;

import com.example.songlibraryapp.singer.entity.Singer;
import com.example.songlibraryapp.singer.repository.SingerRepository;
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

    public Singer findByName(String name){ return singerRepository.findByName(name); }

    public Optional<Singer> findById(UUID id) { return singerRepository.findById(id); }

    public List<Singer> findAll(){
        return singerRepository.findAll();
    }

    public void create(Singer singer){
        singerRepository.save(singer);
    }

    public void delete(UUID id){
        singerRepository.findById(id).ifPresent(singerRepository::delete);
    }



}
