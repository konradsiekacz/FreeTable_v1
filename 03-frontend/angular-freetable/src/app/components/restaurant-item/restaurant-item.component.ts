import { Component, OnInit } from '@angular/core';
import { Restaurant } from 'src/app/common/restaurant';
import { ActivatedRoute } from '@angular/router';
import { CustomerViewService } from 'src/app/services/customer-view.service';
import { RestaurantTable } from 'src/app/common/restaurant-table';
import { CartItem } from 'src/app/common/cart-item';
import {CartService} from 'src/app/services/cart.service';
import { ReservationItem } from 'src/app/common/reservation-item';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { User } from 'src/app/common/user';


@Component({
  selector: 'app-restaurant-item',
  templateUrl: './restaurant-item.component.html',
  styleUrls: ['./restaurant-item.component.css']
})
export class RestaurantItemComponent implements OnInit {

  user: User = new User();
  restaurant: Restaurant = new Restaurant();
  constructor(private customerViewService: CustomerViewService, 
              private route: ActivatedRoute,
              private cartService: CartService,
              private token: TokenStorageService) { }

  ngOnInit(): void {
    this.user = this.token.getUser();
    this.route.paramMap.subscribe(()=>{
      this.handleRestaurantItem();
    })
    
  }
  handleRestaurantItem(){
    // get the "id" param string. convert string to a number using the "+" symbol
    const id: number = +this.route.snapshot.paramMap.get('id');

    this.customerViewService.getRestaurant(id).subscribe(
      data => {
        this.restaurant = data;
      }
    )
  }
  addToCheckout(restaurantTable: RestaurantTable, restaurant: Restaurant, user: User){
    console.log(`Adding to checkout: ${restaurantTable.tableId}, ${restaurantTable}, ${this.user.id}`);
    
    const theReservationItem = new ReservationItem(restaurantTable, restaurant, user);
    this.cartService.addToCheckout(theReservationItem);
    console.log(`Restaurant name in list: ${theReservationItem.restaurantName}, ${restaurantTable}, ${this.user.id}`);

  }

  addToCart(restaurantTable: RestaurantTable, restaurant: Restaurant){
    console.log(`Adding to cart: ${restaurantTable.tableId}, ${restaurantTable.numberOfSeats}`);

    const theCartItem = new CartItem(restaurantTable, restaurant, this.user);
    this.cartService.addToCart(theCartItem);
  }

  
}
