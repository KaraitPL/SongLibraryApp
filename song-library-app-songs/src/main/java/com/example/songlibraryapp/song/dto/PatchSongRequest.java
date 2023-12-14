package com.example.songlibraryapp.song.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchSongRequest {
    private String name;
    private int releaseYear;
}
