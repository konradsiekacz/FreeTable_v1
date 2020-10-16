import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ReservationItem} from '../common/reservation-item';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ReservationItemService {

  private baseUrl = 'http://localhost:8080/api/reservationItems';
  private restaurantIdUrl = 'http://localhost:8080/api/restaurantReservations';

  constructor(private http: HttpClient) { }

  createReservationItems(reservationItems: Object[]): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, reservationItems);
  }
  createReservationItem(reservationItem: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, reservationItem);
  }

  getReservationItemsById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getReservationItemsByRestaurantId(id: number): Observable<any> {
    return this.http.get(`${this.restaurantIdUrl}/${id}`);
  }
}
