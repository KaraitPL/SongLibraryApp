package com.example.SongLibraryApp.Song.controller;

import com.example.SongLibraryApp.Song.SongService;
import com.example.SongLibraryApp.Song.dto.GetSongResponse;
import com.example.SongLibraryApp.Song.dto.GetSongsResponse;
import com.example.SongLibraryApp.Song.dto.PutSongRequest;
import com.example.SongLibraryApp.Song.function.RequestToSongFunction;
import com.example.SongLibraryApp.Song.function.SongToResponseFunction;
import com.example.SongLibraryApp.Song.function.SongsToResponseFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class SongControllerImpl implements SongController{

    private final SongService service;
    private final SongToResponseFunction songToResponse;
    private final SongsToResponseFunction songsToResponse;
    private final RequestToSongFunction requestToSong;

    @Autowired
    public SongControllerImpl(
            SongService service,
            SongToResponseFunction songToResponse,
            SongsToResponseFunction songsToResponse,
            RequestToSongFunction requestToSong
    ){
        this.service = service;
        this.songToResponse = songToResponse;
        this.songsToResponse = songsToResponse;
        this.requestToSong = requestToSong;
    }

    @Override
    public GetSongsResponse getSongs() {
        return songsToResponse.apply(service.findAll());
    }

    @Override
    public GetSongsResponse getSingerSongs(UUID singerId) {
        return service.findAllBySinger(singerId)
                .map(songsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetSongResponse getSong(UUID id) {
        return service.find(id)
                .map(songToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putSong(UUID id, PutSongRequest request) {
        service.create(requestToSong.apply(id, request));
    }

    @Override
    public void deleteSong(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        song -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
