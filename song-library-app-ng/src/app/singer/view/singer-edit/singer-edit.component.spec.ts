import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingerEditComponent } from './singer-edit.component';

describe('SingerEditComponent', () => {
    let component: SingerEditComponent;
    let fixture: ComponentFixture<SingerEditComponent>;

    beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [SingerEditComponent]
        });
        fixture = TestBed.createComponent(SingerEditComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
