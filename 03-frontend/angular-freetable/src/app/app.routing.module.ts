import { RestaurantDetailsComponent } from 'src/app/components/restaurant-details/restaurant-details.component';
import { CreateRestaurantComponent } from 'src/app/components/create-restaurant/create-restaurant.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UpdateRestaurantComponent } from 'src/app/components/update-restaurant/update-restaurant.component';
import { RestaurantListComponent } from 'src/app/components/restaurant-list/restaurant-list.component';
import { CustomerViewComponent } from './components/customer-view/customer-view.component';
import { RestaurantItemComponent } from './components/restaurant-item/restaurant-item.component';
import { AdminMenuComponent } from './components/admin-menu/admin-menu.component';
import { LoginMenuComponent } from './components/login-menu/login-menu.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import {RestuarantTableListComponent} from './components/restuarant-table-list/restuarant-table-list.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ReservationItemListComponent } from './components/reservation-item-list/reservation-item-list.component';
import { UpdateRestaurantTableComponent } from './components/update-restaurant-table/update-restaurant-table.component';
import { RestaurantTableDetailsComponent } from './components/restaurant-table-details/restaurant-table-details.component';
import { CreateRestaurantTableComponent } from './components/create-restaurant-table/create-restaurant-table.component';
import { RestaurantProfileComponent } from './components/restaurant-profile/restaurant-profile.component';
import { RestaurantProfileReservationsComponent } from './components/restaurant-profile-reservations/restaurant-profile-reservations.component';
 
const routes: Routes = [
  { path: 'admin-menu/restaurants', component: RestaurantListComponent },
  { path: 'admin-menu/restaurants/add', component: CreateRestaurantComponent },
  { path: 'admin-menu/tables/add', component: CreateRestaurantTableComponent },
  { path: 'restaurant-profile', component: RestaurantProfileComponent },
  { path: 'restaurant-profile-reservations/:id', component: RestaurantProfileReservationsComponent },
  { path: 'update/:id', component: UpdateRestaurantComponent },
  { path: 'details/:id', component: RestaurantDetailsComponent },
  { path: 'customer', component: CustomerViewComponent },
  { path: 'customer/:id', component: RestaurantItemComponent },
  { path: 'admin-menu', component: AdminMenuComponent },
  { path: 'cart-details', component: CartDetailsComponent },
  { path: 'admin-menu/tables', component: RestuarantTableListComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'reservations', component: ReservationItemListComponent},
  { path: 'update-table/:id', component: UpdateRestaurantTableComponent },
  { path: 'details-table/:id', component: RestaurantTableDetailsComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }