package com.example.songlibraryapp.singer.controller.impl;

import com.example.songlibraryapp.singer.controller.api.SingerController;
import com.example.songlibraryapp.singer.dto.PutSingerRequest;
import com.example.songlibraryapp.singer.function.RequestToSingerFunction;
import com.example.songlibraryapp.singer.service.SingerService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class SingerControllerImpl implements SingerController {

    private final SingerService service;
    private final RequestToSingerFunction requestToSinger;

    @Autowired
    public SingerControllerImpl(
            SingerService service,
            RequestToSingerFunction requestToSinger
    ) {
        this.service = service;
        this.requestToSinger = requestToSinger;
    }

    @Override
    public void putSinger(UUID id, PutSingerRequest request) {
        service.create(requestToSinger.apply(id, request));
    }


    @Override
    public void deleteSinger(UUID id) {
        service.findById(id)
                .ifPresentOrElse(
                        singer -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
