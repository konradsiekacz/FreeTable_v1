import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../common/customer';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/v1/restaurants';

  constructor(private httpClient: HttpClient) { }

  getCustomerList(): Observable<Customer[]> {
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._embedded.customers)
    );
  }
  
}

interface GetResponse {
  _embedded: {
    customers: Customer[];
  }
}