package com.example.songlibraryapp.singer.initialize;


import com.example.songlibraryapp.singer.entity.Singer;
import com.example.songlibraryapp.singer.service.SingerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final SingerService singerService;


    @Autowired
    public InitializeData(SingerService singerService){
        this.singerService = singerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        if(singerService.findAll().isEmpty()) {
            Singer edSheeran = Singer.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9828")).name("Ed Sheeran").age(32).build();
            Singer adamLevine = Singer.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9829")).name("Adam Levine").age(44).build();
            Singer justinTimberlake = Singer.builder().id(UUID.fromString("ffdffd02-505c-4d1c-af3d-f3555c9b9830")).name("Justin Timberlake").age(42).build();

            singerService.create(edSheeran);
            singerService.create(adamLevine);
            singerService.create(justinTimberlake);
        }

    }
}
