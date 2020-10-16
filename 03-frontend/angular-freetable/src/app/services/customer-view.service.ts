import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Restaurant } from '../common/restaurant';

@Injectable({
  providedIn: 'root'
})
export class CustomerViewService {

  private baseUrl = 'http://localhost:8080/api/restaurants';
  private userIdUrl = 'http://localhost:8080/api/restaurant';


  constructor(private httpClient: HttpClient) { }

  getRestaurant(theProductId: number): Observable<Restaurant> {

    // need to build URL based on product id
    const restaurantUrl = `${this.baseUrl}/${theProductId}`;

    return this.httpClient.get<Restaurant>(restaurantUrl);
  }

  getRestaurantByUserId(userId: number): Observable<Restaurant> {
    const url = `${this.userIdUrl}/${userId}`;

    return this.httpClient.get<Restaurant>(url);
  } 

}

interface GetResponseRestaurant {
  _embedded: {
    restaurants: Restaurant[];
  }
}
