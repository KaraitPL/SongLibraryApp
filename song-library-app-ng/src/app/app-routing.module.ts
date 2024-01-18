import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SongListComponent} from "./song/view/song-list/song-list.component";
import {SongViewComponent} from "./song/view/song-view/song-view.component";
import {SongEditComponent} from "./song/view/song-edit/song-edit.component";
import {SingerListComponent} from "./singer/view/singer-list/singer-list.component";
import {SingerViewComponent} from "./singer/view/singer-view/singer-view.component";
import {SingerEditComponent} from "./singer/view/singer-edit/singer-edit.component";

const routes: Routes = [
  {
    component: SongListComponent,
    path: 'songs',
  },
  {
    component: SongViewComponent,
    path: 'songs/:uuid',
  },
  {
    component: SongEditComponent,
    path: 'songs/:uuid/edit',
  },
  {
    component: SingerListComponent,
    path: 'singers',
  },
  {
    component: SingerViewComponent,
    path: 'singers/:uuid',
  },
  {
    component: SingerEditComponent,
    path: 'singers/:uuid/edit',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
