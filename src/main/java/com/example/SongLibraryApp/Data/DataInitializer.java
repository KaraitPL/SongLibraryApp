package com.example.SongLibraryApp.Data;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Singer.SingerService;
import com.example.SongLibraryApp.Song.Song;
import com.example.SongLibraryApp.Song.SongService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements InitializingBean {
    private final SingerService singerService;

    private final SongService songService;

    @Autowired
    public DataInitializer(SingerService singerService, SongService songService){
        this.singerService = singerService;
        this.songService = songService;
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        Singer edSheeran = Singer.builder().name("Ed Sheeran").age(32).build();
        Singer adamLevine = Singer.builder().name("Adam Levine").age(44).build();
        Singer justinTimberlake = Singer.builder().name("Justin Timberlake").age(42).build();

        singerService.create(edSheeran);
        singerService.create(adamLevine);
        singerService.create(justinTimberlake);

        Song perfect = Song.builder().name("Perfect").year(2017).singer(edSheeran).build();
        Song shapeOfYou = Song.builder().name("Shape of You").year(2017).singer(edSheeran).build();
        Song badHabits = Song.builder().name("Bad Habits").year(2021).singer(edSheeran).build();

        Song payphone = Song.builder().name("Payphone").year(2012).singer(adamLevine).build();
        Song memories = Song.builder().name("Memories").year(2021).singer(adamLevine).build();
        Song animals = Song.builder().name("Animals").year(2014).singer(adamLevine).build();

        Song mirrors = Song.builder().name("Mirrors").year(2013).singer(justinTimberlake).build();
        Song cryMeARiver = Song.builder().name("Cry Me a River").year(2002).singer(justinTimberlake).build();

        songService.create(perfect);
        songService.create(shapeOfYou);
        songService.create(badHabits);
        songService.create(payphone);
        songService.create(memories);
        songService.create(animals);
        songService.create(mirrors);
        songService.create(cryMeARiver);



    }
}
