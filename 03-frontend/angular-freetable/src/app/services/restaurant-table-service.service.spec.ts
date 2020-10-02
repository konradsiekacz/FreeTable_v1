import { TestBed } from '@angular/core/testing';

import { RestaurantTableService } from './restaurant-table-service.service';

describe('RestaurantTableServiceService', () => {
  let service: RestaurantTableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestaurantTableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
