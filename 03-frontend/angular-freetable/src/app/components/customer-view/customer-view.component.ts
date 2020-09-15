import { Observable } from "rxjs";
import { Restaurant } from "src/app/common/restaurant";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import { RestaurantService } from "src/app/services/restaurant.service";


@Component({
  selector: "app-customer-view",
  templateUrl: './customer-view.component.html',
  styleUrls: ['./customer-view.component.css']
})
export class CustomerViewComponent implements OnInit {

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
