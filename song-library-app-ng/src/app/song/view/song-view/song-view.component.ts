import { Component, OnInit } from '@angular/core';
import { SongDetails } from '../../model/song-details';
import { SongService } from '../../service/song.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SingerService } from 'src/app/singer/service/singer.service';

@Component({
    selector: 'app-song-view',
    templateUrl: './song-view.component.html',
    styleUrls: ['./song-view.component.css'],
})
export class SongViewComponent implements OnInit {
    song: SongDetails | undefined;
    singerName: string = '';
    singerId: string = '';
    constructor(
        private service: SongService,
        private singerService: SingerService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit(): void {
        this.route.params.subscribe((params) => {
            this.service.getSong(params['uuid']).subscribe((song) => {
                this.song = song;
                this.singerId = song.singer.id;
                console.log(this.song.singer.name);
                this.singerService.getSinger(this.singerId).subscribe((singer) => {
                    this.singerName = singer.name;
                });
            });
        });
    }
}
