import { Component, OnInit } from '@angular/core';
import { SongService } from '../../service/song.service';
import { Songs } from '../../model/songs';
import { Song } from '../../model/song';

@Component({
    selector: 'app-song-list',
    templateUrl: './song-list.component.html',
    styleUrls: ['./song-list.component.css'],
})
export class SongListComponent implements OnInit {
    constructor(private service: SongService) {}

    songs: Songs | undefined;

    ngOnInit(): void {
        this.service.getSongs().subscribe((songs) => (this.songs = songs));
    }

    onDelete(song: Song): void {
        this.service.deleteSong(song.id).subscribe(() => this.ngOnInit());
    }
}
