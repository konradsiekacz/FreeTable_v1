import { Component, OnInit } from '@angular/core';
import { RestaurantTableService } from 'src/app/services/restaurant-table-service.service';
import { RestaurantTable} from 'src/app/common/restaurant-table'
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-restaurant-table',
  templateUrl: './create-restaurant-table.component.html',
  styleUrls: ['./create-restaurant-table.component.css']
})
export class CreateRestaurantTableComponent implements OnInit {

  restaurantTable: RestaurantTable = new RestaurantTable()
  submitted = false;

  constructor(private restaurantTableService: RestaurantTableService,
    private router: Router) { }

  ngOnInit(): void{
  }

  newRestaurantTable(): void{

  }

  save(){
    this.restaurantTableService
    .createRestaurantTable(this.restaurantTable).subscribe(data => {
      console.log(data)
      this.restaurantTable = new RestaurantTable();
      this.gotoList();
    }, 
    error => console.log(error));
    console.log(`tableId: ${this.restaurantTable.tableId}`);
    console.log(`id: ${this.restaurantTable.tableId}`);


  }
  onSubmit() {
    this.submitted = true;
    this.save();    
  }
  gotoList() {
    this.router.navigate(['admin-menu/tabls']);
  }
  list(){
    this.router.navigate(['admin-menu/tables']);
  }

}
