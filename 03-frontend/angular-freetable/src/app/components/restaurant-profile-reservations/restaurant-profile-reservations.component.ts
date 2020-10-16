import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ReservationItem } from 'src/app/common/reservation-item';
import { ReservationItemService } from 'src/app/services/reservation-item.service';

@Component({
  selector: 'app-restaurant-profile-reservations',
  templateUrl: './restaurant-profile-reservations.component.html',
  styleUrls: ['./restaurant-profile-reservations.component.css']
})
export class RestaurantProfileReservationsComponent implements OnInit {
  
  id: number;
  reservationItems: Observable<ReservationItem[]>;
  constructor(private reservationItemService: ReservationItemService,
              private route: ActivatedRoute,
              private router: Router) {}  

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
        this.reservationItems = this.reservationItemService.getReservationItemsByRestaurantId(this.id);
  }

  

}
