import { RestaurantTable } from './restaurant-table';
import { Restaurant } from './restaurant';

export class CartItem {
    imageUrl: string;
    restaurantName: string;    
    tableId: number;
    id: number;
    numberInRestaurant:number;
    numberOfSeats: number;
    quantity: number;

    constructor(restaurantTable: RestaurantTable, restaurant: Restaurant){
        this.imageUrl = restaurant.imageUrl;
        this.restaurantName = restaurant.name;
        this.tableId = restaurantTable.tableId;
        this.id = restaurantTable.id;
        this.numberInRestaurant= restaurantTable.numberInRestaurant;
        this.numberOfSeats = restaurantTable.numberOfSeats;
        this.quantity = 1;
    }
}
