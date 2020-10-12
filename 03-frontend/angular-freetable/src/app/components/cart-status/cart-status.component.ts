import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-status',
  templateUrl: './cart-status.component.html',
  styleUrls: ['./cart-status.component.css']
})
export class CartStatusComponent implements OnInit {

  totalTables: number = 0;
  totalSeats: number = 0;
  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.updateCartStatus();
  }

  updateCartStatus(){
    //subscribe to the cart TotalTables
    this.cartService.totalTables.subscribe(
      data => this.totalTables = data
    );
    //subscribe to the cart TotalSeats
    this.cartService.totalSeats.subscribe(
      data => this.totalSeats = data
    );

    
  }

  
  


}
