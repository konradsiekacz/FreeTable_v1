import { RestaurantTable } from './restaurant-table';
import {Restaurant} from 'src/app/common/restaurant'

export class CartItem {
    restaurantName: string;    
    tableId: number;
    id: number;
    numberInRestaurant:number;
    numberOfSeats;

    quantity: number;



    constructor(restaurantTable: RestaurantTable){
        this.tableId = restaurantTable.tableId;
        this.id = restaurantTable.id;
        this.numberInRestaurant= restaurantTable.numberInRestaurant;

        this.numberOfSeats = restaurantTable.numberOfSeats;
        this.quantity = 1;
    }
}
