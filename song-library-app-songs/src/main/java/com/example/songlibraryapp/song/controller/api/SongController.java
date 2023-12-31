package com.example.songlibraryapp.song.controller.api;

import com.example.songlibraryapp.song.dto.GetSongResponse;
import com.example.songlibraryapp.song.dto.GetSongsResponse;
import com.example.songlibraryapp.song.dto.PatchSongRequest;
import com.example.songlibraryapp.song.dto.PutSongRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SongController {

    @GetMapping("api/songs")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSongsResponse getSongs();

    @GetMapping("/api/singers/{singerId}/songs")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSongsResponse getSingerSongs(
            @PathVariable("singerId")
            UUID userId
    );

    @GetMapping("/api/songs/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSongResponse getSong(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/songs/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putSong(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutSongRequest request
    );

    @PatchMapping("/api/songs/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void patchSong(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchSongRequest request
    );

    @DeleteMapping("/api/songs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSong(
            @PathVariable("id")
            UUID id
    );





}