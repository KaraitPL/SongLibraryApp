package com.example.songlibraryapp.singer.function;

import com.example.songlibraryapp.singer.dto.PutSingerRequest;
import com.example.songlibraryapp.singer.entity.Singer;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToSingerFunction implements BiFunction<UUID, PutSingerRequest, Singer> {
    @Override
    public Singer apply(UUID id, PutSingerRequest request) {
        return Singer.builder()
                .id(id)
                .name(request.getName())
                .age(request.getAge())
                .build();
    }
}
