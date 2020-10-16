import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomerService } from './services/customer.service';
import { RestaurantListComponent } from 'src/app/components/restaurant-list/restaurant-list.component'
import { RestaurantService } from './services/restaurant.service';
import { CreateRestaurantComponent } from 'src/app/components/create-restaurant/create-restaurant.component';
import { UpdateRestaurantComponent } from 'src/app/components/update-restaurant/update-restaurant.component';
import { RestaurantDetailsComponent } from 'src/app/components/restaurant-details/restaurant-details.component';
import { AppRoutingModule } from './app.routing.module';
import { CustomerViewComponent } from './components/customer-view/customer-view.component';
import { RestaurantItemComponent } from './components/restaurant-item/restaurant-item.component';
import { AdminMenuComponent } from './components/admin-menu/admin-menu.component';
import { LoginMenuComponent } from './components/login-menu/login-menu.component';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { RestuarantTableListComponent } from './components/restuarant-table-list/restuarant-table-list.component';
import { BoardAdminComponent } from './components/board-admin/board-admin.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { ReservationItemListComponent } from './components/reservation-item-list/reservation-item-list.component';
import { UpdateRestaurantTableComponent } from './components/update-restaurant-table/update-restaurant-table.component';
import { RestaurantTableDetailsComponent } from './components/restaurant-table-details/restaurant-table-details.component';
import { CreateRestaurantTableComponent } from './components/create-restaurant-table/create-restaurant-table.component';
import { RestaurantProfileComponent } from './components/restaurant-profile/restaurant-profile.component';
import { RestaurantProfileReservationsComponent } from './components/restaurant-profile-reservations/restaurant-profile-reservations.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    RestaurantListComponent,
    CreateRestaurantComponent,
    UpdateRestaurantComponent,
    RestaurantDetailsComponent,
    CustomerViewComponent,
    RestaurantItemComponent,
    AdminMenuComponent,
    LoginMenuComponent,
    CartStatusComponent,
    RestuarantTableListComponent,
    BoardAdminComponent,
    HomeComponent,
    LoginComponent,
    ProfileComponent,
    RegisterComponent,
    CartDetailsComponent,
    ReservationItemListComponent,
    UpdateRestaurantTableComponent,
    RestaurantTableDetailsComponent,
    CreateRestaurantTableComponent,
    RestaurantProfileComponent,
    RestaurantProfileReservationsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [RestaurantService],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
