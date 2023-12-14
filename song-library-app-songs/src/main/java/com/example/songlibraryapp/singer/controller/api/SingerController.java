package com.example.songlibraryapp.singer.controller.api;

import com.example.songlibraryapp.singer.dto.PutSingerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SingerController {

    @DeleteMapping("/api/singers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSinger(
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
}
