package com.example.songlibraryapp.singer.repository;

import com.example.songlibraryapp.singer.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SingerRepository extends JpaRepository<Singer, UUID> {
    List<Singer> findAll();

    Optional<Singer> findById(UUID id);

    Singer findByName(String name);
}