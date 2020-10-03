import { RestaurantTable } from './restaurant-table';
import { Restaurant } from './restaurant';

export class ReservationItem {
    reservationItemId: number;
    restaurantName: string;
    id: number;
    tableId: number;
    numberInRestaurant: number;
    numberOfSeats: number;

    constructor(restaurantTable: RestaurantTable, restaurant: Restaurant){
        this.restaurantName = restaurant.name;
        this.tableId = restaurantTable.tableId;
        this.id = restaurantTable.id;
        this.numberInRestaurant= restaurantTable.numberInRestaurant;
        this.numberOfSeats = restaurantTable.numberOfSeats;
    }
    
}
