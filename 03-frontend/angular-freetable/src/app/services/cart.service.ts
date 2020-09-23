import { Injectable } from '@angular/core';
import {CartItem} from '../common/cart-item'
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItems: CartItem[] = [];

  totalTables: Subject<number> = new Subject<number>();

  totalSeats: Subject<number> = new Subject<number>();

  constructor() { }

  addToCart(theCartItem: CartItem){
    // check if we already have the item in our cart
    let alreadyExistsInCart: boolean = false;
    let existingCartItem: CartItem = undefined;

    if (this.cartItems.length > 0) {
      // find the item in the cart based on item id

      for (let tempCartItem of this.cartItems) {
        if (tempCartItem.tableId === theCartItem.tableId) {
          existingCartItem = tempCartItem;
          break;
        }
      }

      // check if we found it
      alreadyExistsInCart = (existingCartItem != undefined);
    }

    if (alreadyExistsInCart) {
      // increment the quantity
      existingCartItem.quantity++;
    }
    else {
      // just add the item to the array
      this.cartItems.push(theCartItem);
    }

    // compute cart total price and total quantity
    this.computeCartTotals();
  }
  computeCartTotals() {

    let totalTablesValue: number = 0;
    let totalSeatsValue: number = 0;

    for (let currentCartItem of this.cartItems) {
      totalTablesValue += currentCartItem.quantity;
      
    }

    for (let currentCartItem of this.cartItems) {
      totalSeatsValue += currentCartItem.quantity * currentCartItem.numberOfSeats;
      
    }

    // publish the new values ... all customers will receive the new data
    this.totalTables.next(totalTablesValue);
    this.totalSeats.next(totalSeatsValue);

    
  }
  logCartData(totalTablesValue: number, totalSeatsValue: number) {

    console.log('Contents of the cart');
    for (let tempCartItem of this.cartItems) {
      const totalSeats = tempCartItem.quantity * tempCartItem.numberOfSeats;

      console.log(`name: ${tempCartItem.tableId}, quantity=${tempCartItem.quantity}, totalSeats=${totalSeats}`);
    }

  }
}
