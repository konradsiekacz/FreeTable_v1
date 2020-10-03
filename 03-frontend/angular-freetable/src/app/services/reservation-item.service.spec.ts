import { TestBed } from '@angular/core/testing';

import { ReservationItemService } from './reservation-item.service';

describe('ReservationItemService', () => {
  let service: ReservationItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReservationItemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
