import { TestBed } from '@angular/core/testing';

import { RestaurantTableServiceService } from './restaurant-table-service.service';

describe('RestaurantTableServiceService', () => {
  let service: RestaurantTableServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestaurantTableServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
