import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Customer } from 'src/app/common/customer';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list-grid.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[];
  
  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.listCustomers();
  }

  listCustomers() {
    this.customerService.getCustomerList().subscribe(
      data => {
        this.customers = data;
      }
    )
  }

}
