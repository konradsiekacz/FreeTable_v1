import { RestaurantDetailsComponent } from 'src/app/components/restaurant-details/restaurant-details.component';
import { CreateRestaurantComponent } from 'src/app/components/create-restaurant/create-restaurant.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UpdateRestaurantComponent } from 'src/app/components/update-restaurant/update-restaurant.component';
import { RestaurantListComponent } from 'src/app/components/restaurant-list/restaurant-list.component';
import { CustomerViewComponent } from './components/customer-view/customer-view.component';
import { RestaurantItemComponent } from './components/restaurant-item/restaurant-item.component';
import { AdminMenuComponent } from './components/admin-menu/admin-menu.component';

const routes: Routes = [
  { path: '', redirectTo: 'restaurant', pathMatch: 'full' },
  { path: 'restaurants', component: RestaurantListComponent },
  { path: 'restaurants/add', component: CreateRestaurantComponent },
  { path: 'update/:id', component: UpdateRestaurantComponent },
  { path: 'details/:id', component: RestaurantDetailsComponent },
  { path: 'customer', component: CustomerViewComponent },
  { path: 'customer/:id', component: RestaurantItemComponent },
  { path: '', component: AdminMenuComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }