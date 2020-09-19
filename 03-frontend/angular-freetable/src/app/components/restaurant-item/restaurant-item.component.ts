import { Component, OnInit } from '@angular/core';
import { Restaurant } from 'src/app/common/restaurant';
import { ActivatedRoute } from '@angular/router';
import { CustomerViewService } from 'src/app/services/customer-view.service';
import { RestaurantTable } from 'src/app/common/restaurant-table';
import { CartItem } from 'src/app/common/cart-item';
import {CartService} from 'src/app/services/cart.service';


@Component({
  selector: 'app-restaurant-item',
  templateUrl: './restaurant-item.component.html',
  styleUrls: ['./restaurant-item.component.css']
})
export class RestaurantItemComponent implements OnInit {

  restaurant: Restaurant = new Restaurant();
  constructor(private customerViewService: CustomerViewService, 
              private route: ActivatedRoute,
              private cartService: CartService) { }

  ngOnInit(): void {
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
  addToCart(restaurantTable: RestaurantTable){
    console.log(`Adding to cart: ${restaurantTable.tableId}, ${restaurantTable.numberOfSeats}`);

    const theCartItem = new CartItem(restaurantTable);
    this.cartService.addToCart(theCartItem);
  }
}
