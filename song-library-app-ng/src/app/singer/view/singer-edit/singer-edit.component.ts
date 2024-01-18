import { Component } from '@angular/core';
import { SingerService } from '../../service/singer.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SingerForm } from '../../model/SingerForm';

@Component({
    selector: 'app-singer-edit',
    templateUrl: './singer-edit.component.html',
    styleUrls: ['./singer-edit.component.css'],
})
export class SingerEditComponent {
    uuid: string | undefined;

    singer: SingerForm | undefined;

    original: SingerForm | undefined;
    constructor(
        private singerService: SingerService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit() {
        this.route.params.subscribe((params) => {
            this.singerService.getSinger(params['uuid']).subscribe((singer) => {
                this.uuid = singer.id;
                this.singer = {
                    id: singer.id,
                    name: singer.name,
                    age: singer.age,
                };
                this.original = { ...this.singer };
            });
        });
    }
    onSubmit(): void {
        console.log("123");
        this.singerService
            .patchSinger(this.uuid!, this.singer!)
            .subscribe(() => this.router.navigate(['/singers']));
        console.log("123");
    }
}
