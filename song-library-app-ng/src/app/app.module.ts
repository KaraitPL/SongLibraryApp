import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent} from "./components/footer/footer.component";
import { MainComponent} from "./components/main/main.component";
import { NavComponent} from "./components/nav/nav.component";
import {HeaderComponent} from "./components/header/header.component";
import {SongEditComponent} from "./song/view/song-edit/song-edit.component";
import {SongListComponent} from "./song/view/song-list/song-list.component";
import {SongViewComponent} from "./song/view/song-view/song-view.component";
import {SingerEditComponent} from "./singer/view/singer-edit/singer-edit.component";
import {SingerListComponent} from "./singer/view/singer-list/singer-list.component";
import {SingerViewComponent} from "./singer/view/singer-view/singer-view.component";
import { SongService } from './song/service/song.service';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    MainComponent,
    NavComponent,
    HeaderComponent,
    SongEditComponent,
    SongListComponent,
    SongViewComponent,
    SingerEditComponent,
    SingerListComponent,
    SingerViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [SongService],
  bootstrap: [AppComponent]
})
export class AppModule { }
