import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantTableDetailsComponent } from './restaurant-table-details.component';

describe('RestaurantTableDetailsComponent', () => {
  let component: RestaurantTableDetailsComponent;
  let fixture: ComponentFixture<RestaurantTableDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestaurantTableDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantTableDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
