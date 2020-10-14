import { Component, OnInit } from '@angular/core';
import { RestaurantTable } from 'src/app/common/restaurant-table';
import { Observable } from 'rxjs';
import {RestaurantTableService} from 'src/app/services/restaurant-table-service.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-restuarant-table-list',
  templateUrl: './restuarant-table-list.component.html',
  styleUrls: ['./restuarant-table-list.component.css']
})
export class RestuarantTableListComponent implements OnInit {

  restaurantTables: Observable<RestaurantTable[]>;

  constructor(private restaurantTablesService: RestaurantTableService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
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
}
