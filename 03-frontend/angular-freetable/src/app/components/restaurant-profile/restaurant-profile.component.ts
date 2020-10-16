import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { User } from 'src/app/common/user';
import { Restaurant } from 'src/app/common/restaurant';
import { CustomerViewService } from 'src/app/services/customer-view.service';
import { ActivatedRoute } from '@angular/router';
import { RestaurantTable } from 'src/app/common/restaurant-table';
import { Observable } from 'rxjs';
import { RestaurantTableService } from 'src/app/services/restaurant-table-service.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-restaurant-profile',
  templateUrl: './restaurant-profile.component.html',
  styleUrls: ['./restaurant-profile.component.css']
})
export class RestaurantProfileComponent implements OnInit {

  restaurantTables: Observable<RestaurantTable[]>;
  user: User = new User();
  restaurant: Restaurant = new Restaurant();
  constructor(private customerViewService: CustomerViewService,
              private router: Router,
              private route: ActivatedRoute,
              private token: TokenStorageService,
              private restaurantTablesService: RestaurantTableService) { }

  ngOnInit(): void {
    this.user = this.token.getUser();
    this.route.paramMap.subscribe(()=>{
      this.handleRestaurantItem();
    })
    this.reloadData();
    this.restaurantTables = this.restaurantTablesService.getRestaurantTablesList();

    
  }
  handleRestaurantItem(){
    // get the "id" param string. convert string to a number using the "+" symbol
    this.user = this.token.getUser();
    var id = this.user.id
    

    this.customerViewService.getRestaurantByUserId(id).subscribe(
      data => {
        this.restaurant = data;
      }
    )
  }
  
  reloadData() {
    this.restaurantTables = this.restaurantTablesService.getRestaurantTablesList();
  }

  deleteRestaurantTable(id: number) {
    this.restaurantTablesService.deleteRestaurantTable(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  restaurantTableDetails(id: number){
    this.router.navigate(['details-table', id]);
  }
  
  updateRestaurantTable(id: number){
    this.router.navigate(['update-table',id])
  }

  restaurantReservations(id: number){
    this.router.navigate(['restaurant-profile-reservations',id])
  }

}
