import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Singers } from '../model/Singers';
import { Singer } from '../model/Singer';
import { SingerForm } from '../model/SingerForm';
import { SingerDetails } from '../model/SingerDetails';
@Injectable({
  providedIn: 'root',
})
export class SingerService {
  constructor(private http: HttpClient) {}

  getSingers(): Observable<Singers> {
    return this.http.get<Singers>('/api/singers');
  }
  getSinger(uuid: string): Observable<SingerDetails> {
    return this.http.get<SingerDetails>(`/api/singers/${uuid}`);
  }
  deleteSinger(uuid: string): Observable<any> {
    return this.http.delete<Singer>(`/api/singers/${uuid}`);
  }
  putSinger(uuid: string, request: SingerForm): Observable<any> {
    return this.http.put(`/api/singers/${uuid}`, request);
  }
  patchSinger(uuid: string, request: SingerForm): Observable<any> {
    return this.http.patch(`/api/singers/${uuid}`, request);
  }
}
