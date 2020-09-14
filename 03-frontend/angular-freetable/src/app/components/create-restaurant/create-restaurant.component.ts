import { Component, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { Restaurant } from 'src/app/common/restaurant';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-restaurant',
  templateUrl: './create-restaurant.component.html',
  styleUrls: ['./create-restaurant.component.css']
})
export class CreateRestaurantComponent implements OnInit {
  
  restaurant: Restaurant = new Restaurant();
  submitted = false;

  constructor(private restaurantService: RestaurantService,
    private router: Router) { }

  ngOnInit(): void{
  }

  newRestaurant(): void{

  }

  save(){
    this.restaurantService
    .createRestaurant(this.restaurant).subscribe(data => {
      console.log(data)
      this.restaurant = new Restaurant();
      this.gotoList();
    }, 
    error => console.log(error));
  }
  onSubmit() {
    this.submitted = true;
    this.save();    
  }
  gotoList() {
    this.router.navigate(['/restaurants']);
  }
}
