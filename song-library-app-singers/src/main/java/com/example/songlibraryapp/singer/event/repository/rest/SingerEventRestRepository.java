package com.example.songlibraryapp.singer.event.repository.rest;

import com.example.songlibraryapp.singer.entity.Singer;
import com.example.songlibraryapp.singer.event.repository.api.SingerEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class SingerEventRestRepository implements SingerEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public SingerEventRestRepository(RestTemplate template){
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id){
        restTemplate.delete("/api/singers/{id}", id);
    }

    @Override
    public void add(Singer singer){
        restTemplate.put("/api/singers/{id}", singer, singer.getId());
    }
}
