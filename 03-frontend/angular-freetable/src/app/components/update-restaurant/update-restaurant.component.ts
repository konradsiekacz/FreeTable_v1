import { Component, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { Restaurant } from 'src/app/common/restaurant';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-restaurant',
  templateUrl: './update-restaurant.component.html',
  styleUrls: ['./update-restaurant.component.css']
})
export class UpdateRestaurantComponent implements OnInit {
  id: number;
  restaurant: Restaurant;

  constructor(private route: ActivatedRoute,private router: Router,
    private restaurantService: RestaurantService) { }

  ngOnInit(): void {
    this.restaurant = new Restaurant();

    this.id = this.route.snapshot.params['id'];
    
    this.restaurantService.getRestaurant(this.id)
      .subscribe(data => {
        console.log(data)
        this.restaurant = data;
      }, error => console.log(error));
  }

  updateRestaurant() {
    this.restaurantService.updateRestaurant(this.id, this.restaurant)
      .subscribe(data => {
        console.log(data);
        this.restaurant = new Restaurant();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateRestaurant();    
  }

  gotoList() {
    this.router.navigate(['update']);
  }

  list(){
    this.router.navigate(['admin-menu/tables']);
  }
}
