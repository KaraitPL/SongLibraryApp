import { Component, OnInit } from '@angular/core';
import { SingerService } from '../../service/singer.service';
import { Singers } from '../../model/Singers';
import { Singer } from '../../model/Singer';
import { SingerForm } from '../../model/SingerForm';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'app-singer-list',
    templateUrl: './singer-list.component.html',
    styleUrls: ['./singer-list.component.css'],
})
export class SingerListComponent implements OnInit {
    constructor(
        private service: SingerService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    singers: Singers | undefined;
    newSinger: SingerForm = { id: '', name: '', age: 0 };

    ngOnInit(): void {
        this.service.getSingers().subscribe((singers) => (this.singers = singers));
    }
    onDelete(singer: Singer): void {
        this.service.deleteSinger(singer.id).subscribe(() => this.ngOnInit());
    }
    onSubmit(): void {
        this.service
            .putSinger(this.newSinger.id, this.newSinger)
            // .subscribe(() => this.router.navigate(['/singers']));
            .subscribe(() => this.ngOnInit());
    }
}
