package com.example.SongLibraryApp.Singer.controller;

import com.example.SongLibraryApp.Singer.dto.GetSingerResponse;
import com.example.SongLibraryApp.Singer.dto.GetSingersResponse;
import com.example.SongLibraryApp.Singer.dto.PatchSingerRequest;
import com.example.SongLibraryApp.Singer.dto.PutSingerRequest;
import com.example.SongLibraryApp.Song.dto.PutSongRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SingerController {

    @GetMapping("api/singers")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSingersResponse getSingers();

    @GetMapping("/api/singers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSingerResponse getSinger(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/singer/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putSinger(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutSingerRequest request
    );

    @PatchMapping("/api/singer/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchSinger(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchSingerRequest request
    );

    @DeleteMapping("/api/singers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSinger(
            @PathVariable("id")
            UUID id
    );




}
