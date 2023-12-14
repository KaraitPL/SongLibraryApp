package com.example.songlibraryapp.singer.event.repository.api;

import com.example.songlibraryapp.singer.entity.Singer;

import java.util.UUID;

public interface SingerEventRepository {

    void delete(UUID id);
    void add(Singer singer);
}
