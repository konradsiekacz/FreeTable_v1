import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestuarantTableListComponent } from './restuarant-table-list.component';

describe('RestuarantTableListComponent', () => {
  let component: RestuarantTableListComponent;
  let fixture: ComponentFixture<RestuarantTableListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestuarantTableListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestuarantTableListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
