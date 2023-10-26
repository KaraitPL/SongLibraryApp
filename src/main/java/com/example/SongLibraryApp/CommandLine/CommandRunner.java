package com.example.SongLibraryApp.CommandLine;

import com.example.SongLibraryApp.Singer.SingerService;
import com.example.SongLibraryApp.Song.SongService.SongServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CommandRunner implements CommandLineRunner {
    private final SingerService singerService;
    private final SongServiceImpl songService;

    @Autowired
    public CommandRunner(SingerService singerService, SongServiceImpl songService){
        this.singerService = singerService;
        this.songService = songService;
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "get_characters" -> {
                    System.out.println("get");
                }
                case "get_character" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    try {
                        System.out.println("get2");
                    } catch (NoSuchElementException ex) {
                        System.out.println("NOT_FOUND");
                    }
                }
                case "get_character_portrait" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    try {
                        System.out.println("get3");
                    } catch (NoSuchElementException ex) {
                        System.out.println("NOT_FOUND");
                    }
                }
                case "delete_character" -> {
                    try {
                        UUID uuid = UUID.fromString(scanner.next());
                    } catch (NoSuchElementException ex) {
                        System.out.println("Not Found");
                    }
                }
                case "quit" -> {
                    break main_loop;
                }
            }
        }

    }
}
