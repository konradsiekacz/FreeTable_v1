// import { Component, OnInit } from '@angular/core';
// import { RestaurantService } from 'src/app/services/restaurant.service';
// import { Restaurant } from 'src/app/common/restaurant';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-restaurant-list',
//   templateUrl: './restaurant-list.component.html',
//   styleUrls: ['./restaurant-list.component.css']
// })
// export class RestaurantListComponent implements OnInit {

//   restaurants: Restaurant[];
  
//   constructor(private restaurantService: RestaurantService, ) { }

//   ngOnInit() {
//     this.listRestaurants();
//   }

//   listRestaurants() {
//     this.restaurantService.getRestaurantsList().subscribe(
//       data => {
//         this.restaurants = data;
//       }
//     )
//   }

// }

import { RestaurantDetailsComponent } from 'src/app/components/restaurant-details/restaurant-details.component';
import { Observable } from "rxjs";
import { RestaurantService } from "src/app/services/restaurant.service";
import { Restaurant } from "src/app/common/restaurant";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-restaurant-list",
  templateUrl: "./restaurant-list.component.html",
  styleUrls: ["./restaurant-list.component.css"]
})
export class RestaurantListComponent implements OnInit {
  restaurants: Observable<Restaurant[]>;

  constructor(private restaurantService: RestaurantService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.restaurants = this.restaurantService.getRestaurantsList();
  }

  deleteRestaurant(id: number) {
    this.restaurantService.deleteRestaurant(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  restaurantDetails(id: number){
    this.router.navigate(['details', id]);
  }
}