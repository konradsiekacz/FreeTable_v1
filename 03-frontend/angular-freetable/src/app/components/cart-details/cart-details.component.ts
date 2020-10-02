import { Component, OnInit } from '@angular/core';
import { CartItem } from 'src/app/common/cart-item';
import { Restaurant } from 'src/app/common/restaurant';
import { CartService } from 'src/app/services/cart.service';
import { RestaurantService } from 'src/app/services/restaurant.service';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {

  cartItems: CartItem[] = [];
  restaurant: Restaurant;
  totalTables: number =0;
  totalSeats: number =0;
  constructor(private cartService: CartService,
              private restaurantService: RestaurantService) { }

  ngOnInit(): void {
    this.listCartDetails()
  }
  listCartDetails() {
    // get a handle to the cart items
    this.cartItems = this.cartService.cartItems;

    // subscribe to the cart totalSeats
    this.cartService.totalSeats.subscribe(
      data => this.totalSeats = data
    );

    // subscribe to the cart totalQuantity
    this.cartService.totalTables.subscribe( 
      data => this.totalTables = data
    );

    // compute cart total price and quantity
    this.cartService.computeCartTotals();

  }
  

}
