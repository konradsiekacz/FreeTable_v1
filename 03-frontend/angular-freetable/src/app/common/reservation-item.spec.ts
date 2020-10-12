import { ReservationItem } from './reservation-item';
import { Restaurant } from './restaurant';
import { RestaurantTable } from './restaurant-table';
import { User } from './user';

describe('ReservationItem', () => {
  it('should create an instance', () => {
    expect(new ReservationItem()).toBeTruthy();
  });
});
