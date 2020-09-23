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

  getRestaurantTable(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createRestaurantTable(restaurantTable: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, RestaurantTable);
  }

  updateRestaurantTable(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteRestaurantTable(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getRestaurantTablesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
