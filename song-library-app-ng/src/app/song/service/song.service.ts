import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Songs } from '../model/songs';
import { SongDetails } from '../model/song-details';
import { SongForm } from '../model/song-form';
import { SingerDetails } from 'src/app/singer/model/SingerDetails';
import { NewSong } from '../model/song-new';

@Injectable({
    providedIn: 'root',
})
export class SongService {
    constructor(private http: HttpClient) {}

    getSongs(): Observable<Songs> {
        return this.http.get<Songs>('/api/songs');
    }

    getSong(uuid: string): Observable<SongDetails> {
        return this.http.get<SongDetails>(`/api/songs/${uuid}`);
    }
    getSingerSongs(uuid: string): Observable<SingerDetails> {
        return this.http.get<SingerDetails>(`/api/singers/${uuid}/songs`);
    }

    deleteSong(uuid: string): Observable<any> {
        return this.http.delete(`/api/songs/${uuid}`);
    }

    patchSong(uuid: string, request: SongForm): Observable<any> {
        return this.http.patch(`/api/songs/${uuid}`, request);
    }
    putSong(uuid: string, request: NewSong): Observable<any> {
        return this.http.put(`/api/songs/${uuid}`, request);
    }
}
