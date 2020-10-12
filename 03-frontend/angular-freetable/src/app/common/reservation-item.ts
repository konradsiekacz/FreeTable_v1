import { RestaurantTable } from './restaurant-table';
import { Restaurant } from './restaurant';
import { User } from './user';

export class ReservationItem {
    id: number;
    username: string;
    restaurantName: string;
    restaurantId: number;
    tableId: number;
    numberInRestaurant: number;
    numberOfSeats: number;

    constructor(restaurantTable: RestaurantTable, restaurant: Restaurant, user: User){
        this.id = user.id;
        this.username = user.username;
        this.restaurantName = restaurant.name;
        this.restaurantId = restaurant.restaurantId;
        this.tableId = restaurantTable.tableId;
        this.numberInRestaurant= restaurantTable.numberInRestaurant;
        this.numberOfSeats = restaurantTable.numberOfSeats;
    }
    
}
