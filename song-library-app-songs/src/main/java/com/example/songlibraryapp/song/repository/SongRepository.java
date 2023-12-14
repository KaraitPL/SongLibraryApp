package com.example.songlibraryapp.song.repository;

import com.example.songlibraryapp.singer.entity.Singer;
import com.example.songlibraryapp.song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID> {
    List<Song> findAll();

    List<Song> findAllBySinger(Singer singer);
}
