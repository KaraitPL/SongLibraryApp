package com.example.SongLibraryApp.Singer.controller;

import com.example.SongLibraryApp.Singer.SingerService;
import com.example.SongLibraryApp.Singer.dto.GetSingerResponse;
import com.example.SongLibraryApp.Singer.dto.GetSingersResponse;
import com.example.SongLibraryApp.Singer.dto.PutSingerRequest;
import com.example.SongLibraryApp.Singer.function.RequestToSingerFunction;
import com.example.SongLibraryApp.Singer.function.SingerToResponseFunction;
import com.example.SongLibraryApp.Singer.function.SingersToResponseFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class SingerControllerImpl implements SingerController{

    private final SingerService service;
    private final SingerToResponseFunction singerToResponse;
    private final SingersToResponseFunction singersToResponse;
    private final RequestToSingerFunction requestToSinger;

    @Autowired
    public SingerControllerImpl(
            SingerService service,
            SingerToResponseFunction singerToResponse,
            SingersToResponseFunction singersToResponse,
            RequestToSingerFunction requestToSinger
    ) {
        this.service = service;
        this.singerToResponse = singerToResponse;
        this.singersToResponse = singersToResponse;
        this.requestToSinger = requestToSinger;
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
