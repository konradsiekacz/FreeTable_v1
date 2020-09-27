import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ReservationItem} from '../common/reservation-item';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ReservationItemService {

  private baseUrl = 'http://localhost:8080/api/reservationItems';

  constructor(private http: HttpClient) { }

  createReservationItems(reservationItems: Object[]): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, reservationItems);
  }
  createReservationItem(reservationItem: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, reservationItem);
  }
}
