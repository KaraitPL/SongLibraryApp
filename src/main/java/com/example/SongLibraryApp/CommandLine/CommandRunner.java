package com.example.SongLibraryApp.CommandLine;

import com.example.SongLibraryApp.Singer.Singer;
import com.example.SongLibraryApp.Singer.SingerService;
import com.example.SongLibraryApp.Song.Song;
import com.example.SongLibraryApp.Song.SongRepository;
import com.example.SongLibraryApp.Song.SongService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CommandRunner implements CommandLineRunner {
    private final SingerService singerService;
    private final SongService songService;

    @Autowired
    public CommandRunner(SingerService singerService, SongService songService){
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
                case "help" -> {
                    System.out.println("Available instructions:\n" +
                            "1. get_all_categories\n" +
                            "2. get_all_songs\n" +
                            "3. create_song\n" +
                            "4. delete_song\n" +
                            "5. quit");
                }
                case "get_all_categories" -> {
                    System.out.println(singerService.findAll());
                }
                case "get_all_songs" -> {
                    System.out.println(songService.findAll());
                }
                case "create_song" -> {
                    List<Singer> availableSingers = singerService.findAll();
                    if (availableSingers.size() == 0) {
                        System.out.print("There is no singers");
                        break;
                    }
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter year of release: ");
                    int yearOfRelease = scanner.nextInt();
                    System.out.println("Enter singer id: ");
                    while (true) {
                        String input = scanner.next();
                        UUID id = UUID.fromString(input);
                        if (singerService.findById(id).isPresent()) {
                            Singer singer = singerService.findById(id).get();
                            Song newSong = Song.builder().name(name).year(yearOfRelease).singer(singer).build();
                            songService.create(newSong);
                            break;
                        }
                    }
//                    System.out.println("Choose singer:");
//                    for(int i = 0; i < availableSingers.size(); i++){
//                        System.out.println(i+1 + ". " + availableSingers.get(i).getName());
//                    }
//                    while(true){
//                        int number = scanner.nextInt();
//                        if(number <= availableSingers.size()) {
//                            Song newSong = Song.builder().name(name).year(yearOfRelease).singer(availableSingers.get(number-1)).build();
//                            songService.create(newSong);
//                            break;
//                        }
//                    }
                    System.out.println("Song successfully created");
                }
                case "delete_song" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    songService.delete(uuid);

//                    List<Song> availableSongs = songService.findAll();
//                    System.out.println("Choose song to delete:");
//                    for (int i = 0; i < availableSongs.size(); i++){
//                        System.out.println(i+1 + ". " + availableSongs.get((i)));
//                    }
//                    while(true){
//                        int number = scanner.nextInt();
//                        if(number <= availableSongs.size()) {
//                            songService.delete(availableSongs.get(number-1).getId());
//                            break;
//                        }
//                    }
//                    System.out.println("Song successfully deleted");
                }
                case "quit" -> {
                    break main_loop;
                }
            }
        }

    }
}
