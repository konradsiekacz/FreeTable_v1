import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationItemListComponent } from './reservation-item-list.component';

describe('ReservationItemListComponent', () => {
  let component: ReservationItemListComponent;
  let fixture: ComponentFixture<ReservationItemListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservationItemListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationItemListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
