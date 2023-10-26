package com.example.SongLibraryApp.Song;

import com.example.SongLibraryApp.Singer.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID> {

    List<Song> findAllBySinger(Singer singer);

    Optional<Song> findById(UUID id);
}
