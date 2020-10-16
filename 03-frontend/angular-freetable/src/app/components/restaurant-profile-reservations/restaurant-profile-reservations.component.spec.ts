import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantProfileReservationsComponent } from './restaurant-profile-reservations.component';

describe('RestaurantProfileReservationsComponent', () => {
  let component: RestaurantProfileReservationsComponent;
  let fixture: ComponentFixture<RestaurantProfileReservationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestaurantProfileReservationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantProfileReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
