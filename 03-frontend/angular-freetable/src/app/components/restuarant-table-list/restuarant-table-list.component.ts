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

  constructor(private restaurantTableService: RestaurantTableService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.restaurantTables = this.restaurantTableService.getRestaurantTablesList();
  }

  deleteRestaurantTable(tableId: number) {
    this.restaurantTableService.deleteRestaurantTable(tableId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  restaurantTableDetails(tableId: number){
    this.router.navigate(['admin-menu/tables/details', tableId]);
  }
  
  updateRestaurantTable(tableId: number){
    this.router.navigate(['admin-menu/tables/update',tableId])
  }
}
