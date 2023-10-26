package com.example.SongLibraryApp.Singer;

import com.example.SongLibraryApp.Song.Song;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "singers")
public class Singer implements Comparable<Singer>, Serializable {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "singer", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Song> songs = new ArrayList<>();

    //Nie wiadmo czy będzie działało -> podczas tworzenia singer nie
    public static class SingerBuilder {
        public Singer build(){
            UUID id = UUID.randomUUID();
            Singer singer = new Singer(id, this.name, this.age, new ArrayList<Song>());
            return singer;
        }
    }




    @Override
    public String toString() {
        return "\nSinger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", songs=" + songs +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singer singer = (Singer) o;
        return age == singer.age && Objects.equals(name, singer.name) && Objects.equals(songs, singer.songs);
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (Song song : songs) {
            sum += song.getName().length();
            sum += song.getYear();
        }
        return name.length() + age + sum;
    }

    @Override
    public int compareTo(Singer other){
        if(this.name.compareTo(other.name) != 0){
            return this.name.compareTo(other.name);
        }
        else if(this.age != other.age){
            return this.age - other.age;
        }
        else{
            return this.songs.size() - other.songs.size();
        }
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void sortSongs(){
        songs.sort(Song::compareTo);
    }
}
