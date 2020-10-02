import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RestaurantTable } from '../common/restaurant-table';

@Injectable({
  providedIn: 'root'
})
export class RestaurantTableService {

private baseUrl = 'http://localhost:8080/api/tables';

  constructor(private http: HttpClient) { }

  getRestaurantTable(tableId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${tableId}`);
  }

  createRestaurantTable(restaurantTable: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, restaurantTable);
  }

  updateRestaurantTable(tableId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${tableId}`, value);
  }

  deleteRestaurantTable(tableId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${tableId}`, { responseType: 'text' });
  }

  getRestaurantTablesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
