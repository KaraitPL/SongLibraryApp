package com.example.songlibraryapp.singer.controller.impl;

import com.example.songlibraryapp.singer.controller.api.SingerController;
import com.example.songlibraryapp.singer.dto.GetSingerResponse;
import com.example.songlibraryapp.singer.dto.GetSingersResponse;
import com.example.songlibraryapp.singer.dto.PatchSingerRequest;
import com.example.songlibraryapp.singer.dto.PutSingerRequest;
import com.example.songlibraryapp.singer.function.RequestToSingerFunction;
import com.example.songlibraryapp.singer.function.SingerToResponseFunction;
import com.example.songlibraryapp.singer.function.SingersToResponseFunction;
import com.example.songlibraryapp.singer.function.UpdateSingerWithRequestFunction;
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
    private final SingerToResponseFunction singerToResponse;
    private final SingersToResponseFunction singersToResponse;
    private final RequestToSingerFunction requestToSinger;
    private final UpdateSingerWithRequestFunction updateSinger;

    @Autowired
    public SingerControllerImpl(
            SingerService service,
            SingerToResponseFunction singerToResponse,
            SingersToResponseFunction singersToResponse,
            RequestToSingerFunction requestToSinger,
            UpdateSingerWithRequestFunction updateSinger
    ) {
        this.service = service;
        this.singerToResponse = singerToResponse;
        this.singersToResponse = singersToResponse;
        this.requestToSinger = requestToSinger;
        this.updateSinger = updateSinger;
    }

    @Override
    public GetSingersResponse getSingers() {
        return singersToResponse.apply(service.findAll());
    }

    @Override
    public GetSingerResponse getSinger(UUID id) {
        return service.findById(id)
                .map(singerToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putSinger(UUID id, PutSingerRequest request) {
        service.create(requestToSinger.apply(id, request));
    }

    @Override
    public void patchSinger(UUID id, PatchSingerRequest request) {
        service.create(updateSinger.apply(service.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), request));
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
