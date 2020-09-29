import { Component, OnInit } from '@angular/core';
import { RestaurantTable } from 'src/app/common/restaurant-table';
import { ActivatedRoute, Router } from '@angular/router';
import { RestaurantTableService } from 'src/app/services/restaurant-table-service.service';
import { dashCaseToCamelCase } from '@angular/compiler/src/util';

@Component({
  selector: 'app-update-restaurant-table',
  templateUrl: './update-restaurant-table.component.html',
  styleUrls: ['./update-restaurant-table.component.css']
})
export class UpdateRestaurantTableComponent implements OnInit {

  tableId: number;
  restaurantTable: RestaurantTable;

  constructor(private route: ActivatedRoute, private router: Router, private restaurantTableService: RestaurantTableService) { }

  ngOnInit(): void {

    this.restaurantTable = new RestaurantTable;
    this.tableId = this.route.snapshot.params['id'];

    this.restaurantTableService.getRestaurantTable(this.tableId)
      .subscribe(data => {
        console.log(data)
        this.restaurantTable = data;
      }, error => console.log(error));
    }

    updateRestaurantTable() {
      this.restaurantTableService.updateRestaurantTable(this.tableId, this.restaurantTable)
        .subscribe(data => {
          console.log(data);
          this.restaurantTable = new RestaurantTable();
          this.gotoList();
        }, error => console.log(error));
    }

    onSubmit() {
      this.updateRestaurantTable();    
    }

    gotoList() {
      this.router.navigate(['admin-menu/tables']);
    }

}
