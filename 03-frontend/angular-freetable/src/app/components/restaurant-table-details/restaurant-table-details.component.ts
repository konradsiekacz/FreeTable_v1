import { Component, OnInit } from '@angular/core';
import { RestaurantTable } from 'src/app/common/restaurant-table';
import { ActivatedRoute, Router } from '@angular/router';
import { RestaurantTableService } from 'src/app/services/restaurant-table-service.service';

@Component({
  selector: 'app-restaurant-table-details',
  templateUrl: './restaurant-table-details.component.html',
  styleUrls: ['./restaurant-table-details.component.css']
})
export class RestaurantTableDetailsComponent implements OnInit {

  tableId: number;
  restaurantTable: RestaurantTable;

  constructor(private route: ActivatedRoute, private router: Router,
    private restaurantTableService: RestaurantTableService) { }

    ngOnInit(): void {
      this.restaurantTable = new RestaurantTable();
  
      this.tableId = this.route.snapshot.params['id'];
      
      this.restaurantTableService.getRestaurantTable(this.tableId)
        .subscribe(data => {
          console.log(data)
          this.restaurantTable = data;
        }, error => console.log(error));
    }

    list(){
      this.router.navigate(['admin-menu/tables']);
    }

}
