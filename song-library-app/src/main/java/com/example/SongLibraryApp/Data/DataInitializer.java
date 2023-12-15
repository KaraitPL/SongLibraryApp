package com.example.SongLibraryApp.Data;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Singer.SingerService;
import com.example.SongLibraryApp.Song.Song;
import com.example.SongLibraryApp.Song.SongService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
        Singer edSheeran = Singer.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9828")).name("Ed Sheeran").age(32).build();
        Singer adamLevine = Singer.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9829")).name("Adam Levine").age(44).build();
        Singer justinTimberlake = Singer.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9830")).name("Justin Timberlake").age(42).build();

        singerService.create(edSheeran);
        singerService.create(adamLevine);
        singerService.create(justinTimberlake);

        Song perfect = Song.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9820")).name("Perfect").year(2017).singer(edSheeran).build();
        Song shapeOfYou = Song.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9821")).name("Shape of You").year(2017).singer(edSheeran).build();
        Song badHabits = Song.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9822")).name("Bad Habits").year(2021).singer(edSheeran).build();

        Song payphone = Song.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9823")).name("Payphone").year(2012).singer(adamLevine).build();
        Song memories = Song.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9824")).name("Memories").year(2021).singer(adamLevine).build();
        Song animals = Song.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9825")).name("Animals").year(2014).singer(adamLevine).build();

        Song mirrors = Song.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9826")).name("Mirrors").year(2013).singer(justinTimberlake).build();
        Song cryMeARiver = Song.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9827")).name("Cry Me a River").year(2002).singer(justinTimberlake).build();

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
