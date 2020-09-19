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
