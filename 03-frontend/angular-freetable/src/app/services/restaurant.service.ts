// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Restaurant } from '../common/restaurant';
// import { Observable } from 'rxjs';
// import { map } from 'rxjs/operators';

// @Injectable({
//   providedIn: 'root'
// })
// export class RestaurantService {

//   private baseUrl = 'http://localhost:8080/api/restaurants';

//   constructor(private httpClient: HttpClient) { }

//   getRestaurantList(): Observable<Restaurant[]> {
//     return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
//       map(response => response._embedded.restaurants)
//     );
//   }
//   createRestaurant(restaurant: Object): Observable<Object> {
//     return this.httpClient.post(`${this.baseUrl}`, restaurant);
//   }
// }

// interface GetResponse {
//   _embedded: {
//     restaurants: Restaurant[];
//   }
// }

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restaurant } from '../common/restaurant';


@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

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
