import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ReservationItem } from 'src/app/common/reservation-item';
import { User } from 'src/app/common/user';
import { ReservationItemService } from 'src/app/services/reservation-item.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-reservation-item-list',
  templateUrl: './reservation-item-list.component.html',
  styleUrls: ['./reservation-item-list.component.css']
})
export class ReservationItemListComponent implements OnInit {

  user: User;
  reservationItems: Observable<ReservationItem[]>;
  constructor(private reservationItemService: ReservationItemService,
              private token: TokenStorageService) {}

  

  ngOnInit(): void {
    this.user = this.token.getUser();
    var id = this.user.id
    this.reservationItems = this.reservationItemService.getReservationItemsById(id);
    console.log(`id: ${id}`);


  }

}
