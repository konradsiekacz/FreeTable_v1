import { Component, OnInit } from '@angular/core';
import { CartItem } from 'src/app/common/cart-item';
import { Restaurant } from 'src/app/common/restaurant';
import { CartService } from 'src/app/services/cart.service';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { ReservationItem } from 'src/app/common/reservation-item';
import {ReservationItemService} from 'src/app/services/reservation-item.service'
import { Router } from '@angular/router';
import { CartStatusComponent } from '../cart-status/cart-status.component';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/common/user';
import { Subject } from 'rxjs';


@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {

  cartItems: CartItem[] = [];
  restaurant: Restaurant;
  user: User;
  reservationItems: ReservationItem []=[];

  component: CartStatusComponent;

  totalTables: number =0;
  totalSeats: number =0;

  submitted = false;

  constructor(private cartService: CartService,
              private restaurantService: RestaurantService,
              private reservationItemService: ReservationItemService,
              private userService: UserService,
              private router: Router) { }

  ngOnInit(): void {
    this.listCartDetails()
    this.listReservationItems()    
    
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
  listReservationItems(){
    this.reservationItems = this.cartService.reservationItems;
  }
  save(){
    
     this.reservationItemService
    .createReservationItems(this.cartItems).subscribe(data=>{
      console.log(data)
      // this.gotoList();      
    },
    error => console.log(error));
    for(var index in this.cartItems){
      console.log(`cart Items: ${this.cartItems[index].restaurantName}`);
          

    }
    this.emptyCartItems();
    this.cartService.cleanCart();    
    
  }
  
  onSubmit() {
    this.submitted = true;
    this.save();
    

  }
  gotoList() {
    this.router.navigate(['customer']);
  }
  list(){
    this.router.navigate(['customer']);
  }

  emptyCartItems() {
    //empty your array
    this.cartItems.length = 0;
  }
  
    
  

}
