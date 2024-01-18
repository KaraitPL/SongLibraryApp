import { Component, OnInit } from '@angular/core';
import { Songs } from '../../model/songs';
import { SongService } from '../../service/song.service';
import { Song } from '../../model/song';
import { SongForm } from '../../model/song-form';
import { Singers } from 'src/app/singer/model/Singers';
import { ActivatedRoute, Router } from '@angular/router';
import { SingerService } from 'src/app/singer/service/singer.service';

@Component({
    selector: 'app-song-edit',
    templateUrl: './song-edit.component.html',
    styleUrls: ['./song-edit.component.css'],
})
export class SongEditComponent implements OnInit {
    uuid: string | undefined;

    song: SongForm | undefined;

    original: SongForm | undefined;

    singers: Singers | undefined;

    constructor(
        private songService: SongService,
        private singerService: SingerService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit() {
        this.route.params.subscribe((params) => {
            this.singerService.getSingers().subscribe((singers) => (this.singers = singers));
            this.songService.getSong(params['uuid']).subscribe((song) => {
                this.uuid = song.id;
                this.song = {
                    name: song.name,
                    releaseYear: song.releaseYear,
                };
                this.original = { ...this.song };
            });
        });
    }

    onSubmit(): void {
        this.songService
            .patchSong(this.uuid!, this.song!)
            .subscribe(() => this.router.navigate(['/songs']));

    }
}
