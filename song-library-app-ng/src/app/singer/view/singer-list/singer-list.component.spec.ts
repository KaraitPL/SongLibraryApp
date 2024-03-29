import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingerListComponent } from './singer-list.component';

describe('SingerListComponent', () => {
    let component: SingerListComponent;
    let fixture: ComponentFixture<SingerListComponent>;

    beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [SingerListComponent],
        });
        fixture = TestBed.createComponent(SingerListComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
