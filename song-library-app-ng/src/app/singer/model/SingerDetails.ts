import { Song } from 'src/app/song/model/song';

export interface SingerDetails {
    id: string;
    name: string;
    age: number;
    songs: Song[];
}
