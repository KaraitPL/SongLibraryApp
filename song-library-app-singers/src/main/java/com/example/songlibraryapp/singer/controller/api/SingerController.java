package com.example.songlibraryapp.singer.controller.api;

import com.example.songlibraryapp.singer.dto.GetSingerResponse;
import com.example.songlibraryapp.singer.dto.GetSingersResponse;
import com.example.songlibraryapp.singer.dto.PatchSingerRequest;
import com.example.songlibraryapp.singer.dto.PutSingerRequest;
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

    @PutMapping("/api/singers/{id}")
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
