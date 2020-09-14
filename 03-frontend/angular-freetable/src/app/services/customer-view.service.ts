import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Restaurant } from '../common/restaurant';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerViewService {

  private baseUrl = 'http://localhost:8080/api/restaurants';

  constructor(private http: HttpClient) { }

  getRestaurant(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createRestaurant(restaurant: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, restaurant);
  }

  updateRestaurant(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteRestaurant(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getRestaurantsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}