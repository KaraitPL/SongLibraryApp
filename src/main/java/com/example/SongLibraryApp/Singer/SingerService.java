package com.example.SongLibraryApp.Singer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingerService {

    public final SingerRepository singerRepository;
    @Autowired
    public SingerService(SingerRepository singerRepository){
        this.singerRepository = singerRepository;
    }
}
