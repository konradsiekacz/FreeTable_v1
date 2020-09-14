import { Component, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { Restaurant } from 'src/app/common/restaurant';
import { ActivatedRoute, Router } from '@angular/router';
import { RestaurantListComponent} from 'src/app/components/restaurant-list/restaurant-list.component'

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit {
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
  list(){
    this.router.navigate(['restaurants']);
  }

}
