import { Singer } from 'src/app/singer/model/Singer';

export interface SongDetails {
    id: string;
    name: string;
    releaseYear: number;
    singer: Singer;
}
