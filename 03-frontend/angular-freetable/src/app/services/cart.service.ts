import { Injectable } from '@angular/core';
import {CartItem} from '../common/cart-item'
import { Subject } from 'rxjs';
import { ReservationItem } from '../common/reservation-item';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItems: CartItem[] = [];
  reservationItems: ReservationItem[]= [];

  totalTables: Subject<number> = new Subject<number>();

  totalSeats: Subject<number> = new Subject<number>();

  constructor() { }

  addToCheckout(theReservationItem: ReservationItem){
    // check if we already have the reservation item in our reservation
    let alreadyExistsInReservation: boolean = false;
    let existingCartReservation: ReservationItem = undefined;

    if (this.reservationItems.length > 0) {
      // find the item in the reservation based on item id

      for (let tempReservationItem of this.reservationItems) {
        if (theReservationItem.tableId === theReservationItem.tableId) {
          existingCartReservation = tempReservationItem;
          break;
        }
      }

      // check if we found it
      alreadyExistsInReservation = (existingCartReservation != undefined);
    }

    if (alreadyExistsInReservation) {
      // some statment we can use later
      
    }
    else {
      // just add the item to the array
      this.reservationItems.push(theReservationItem);
    }

    
  }

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
  cleanCart() {

    let totalTablesValue: number = 0;
    let totalSeatsValue: number = 0;

    
    this.totalTables.next(totalTablesValue);
    this.totalSeats.next(totalSeatsValue);

    
  }
}
