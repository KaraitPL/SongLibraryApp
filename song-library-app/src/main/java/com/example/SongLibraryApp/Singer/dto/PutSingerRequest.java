package com.example.SongLibraryApp.Singer.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutSingerRequest {
    private String name;
    private int age;
}
