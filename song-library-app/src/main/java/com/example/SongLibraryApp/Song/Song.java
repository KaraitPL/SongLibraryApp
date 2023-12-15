package com.example.SongLibraryApp.Song;

import com.example.SongLibraryApp.Singer.Singer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "songs")
public class Song implements Comparable<Song>, Serializable {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "release_year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "singer")
    private Singer singer;

//    public static class SongBuilder {
//        public Song build() {
//            UUID id = UUID.randomUUID();
//            Song song = new Song(id, this.name, this.year, this.singer);
//            singer.addSong(song);
//            return song;
//        }
//    }

    @Override
    public String toString() {
        return "\nSong{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", singer=" + singer.getName() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return year == song.year && Objects.equals(name, song.name) && Objects.equals(singer, song.singer);
    }

    @Override
    public int hashCode() {
        return name.length() + year + singer.getName().length();
    }

    @Override
    public int compareTo(Song other){
        if(this.name.compareTo(other.name) != 0){
            return this.name.compareTo(other.name);
        }
        else if(this.year != other.year){
            return this.year - other.year;
        }
        else{
            return this.singer.compareTo(other.singer);
        }
    }

}
