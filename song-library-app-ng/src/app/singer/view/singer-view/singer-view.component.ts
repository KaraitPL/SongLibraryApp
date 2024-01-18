import { Component, OnInit } from '@angular/core';
import { SingerDetails } from '../../model/SingerDetails';
import { SingerService } from '../../service/singer.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SongService } from 'src/app/song/service/song.service';
import { NewSong } from 'src/app/song/model/song-new';
import {Singer} from "../../model/Singer";
import {Song} from "../../../song/model/song";

@Component({
    selector: 'app-singer-view',
    templateUrl: './singer-view.component.html',
    styleUrls: ['./singer-view.component.css'],
})
export class SingerViewComponent implements OnInit {
    singerSongs: SingerDetails | any;
    singer: SingerDetails | any;
    singerId: string = '';
    newSongId: string = '';
    newSong: NewSong = { name: '', releaseYear: 0, singer: '' };
    constructor(
        private singerService: SingerService,
        private songService: SongService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit(): void {
        this.route.params.subscribe((params) => {
            this.songService.getSingerSongs(params['uuid']).subscribe((singerSongs) => {
                this.singerSongs = singerSongs;
                this.singerId = params['uuid'];
            });
            this.singerService.getSinger(params['uuid']).subscribe((singer) => {
                this.singer = singer;
            });
        });
    }
    onSubmit(): void {
        this.newSong.singer = this.singerId;

        this.songService
            .putSong(this.newSongId, this.newSong)
            .subscribe(() => this.router.navigate(['/songs']));
    }

    onDelete(song: Song): void {
        this.songService.deleteSong(song.id).subscribe(() => this.ngOnInit());
    }
}
