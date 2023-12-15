package com.example.songlibraryapp.singer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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

//    @OneToMany(mappedBy = "singer", cascade = CascadeType.REMOVE)
//    @Builder.Default
//    private List<Song> songs = new ArrayList<>();

//    public static class SingerBuilder {
//        public Singer build(){
//            UUID id = UUID.randomUUID();
//            Singer singer = new Singer(id, this.name, this.age, new ArrayList<Song>());
//            return singer;
//        }
//    }




    @Override
    public String toString() {
        return "\nSinger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singer singer = (Singer) o;
        return age == singer.age && Objects.equals(name, singer.name);
    }

    @Override
    public int hashCode() {
        return (int)((name.length() + age) * Math.pow(name.length(), 2));
    }

    @Override
    public int compareTo(Singer other){
        if(this.name.compareTo(other.name) != 0){
            return this.name.compareTo(other.name);
        }
        else{
            return this.age - other.age;
        }
    }


}
