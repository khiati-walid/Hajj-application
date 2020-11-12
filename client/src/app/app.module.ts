import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MedecinComponent } from './components/medecin/medecin.component';
import { LoginComponent } from './components/login/login.component';
import { BoardAdminComponent } from './components/board-admin/board-admin.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AuthGaurdService } from './_services/auth-gaurd.service';
import {HttpClientModule} from '@angular/common/http';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import {JwtModule} from '@auth0/angular-jwt';
import {TirageComponent} from './components/tirage/tirage.component';
import { VolComponent } from './components/vol/vol.component';
import {HotelListComponent} from './components/hotel-list/hotel-list.component';
import { CreateCustomerComponent } from './components/create-vol/create-vol.component';
import { CustomerDetailsComponent } from './components/vol-details/vol-details.component';
import { CustomersListComponent } from './components/vol-list/vol-list.component';
import { SearchCustomersComponent } from './components/search-vol/search-vol.component';
import { CreateHotelComponent } from './components/create-hotel/create-hotel.component';
import { UpdateHotelComponent } from './components/update-hotel/update-hotel.component';
import { HotelDetailsComponent } from './components/hotel-details/hotel-details.component';
/* export function tokenGetter(){
 return localStorage.getItem('token');
}*/
// const AUTH_API = ['http://localhost:8096'] ;


@NgModule({
  declarations: [
    AppComponent,
    HomeComponentComponent,
    CreateCustomerComponent,
    CustomerDetailsComponent,
    NavbarComponent,
    CustomersListComponent,
    MedecinComponent,
    LoginComponent,
    TirageComponent,
    BoardAdminComponent,
    SearchCustomersComponent,
    VolComponent,
    HotelListComponent,
    CreateHotelComponent,
    UpdateHotelComponent,
    HotelDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  /* JwtModule.forRoot({
     config: {
       tokenGetter: tokenGetter,
       allowedDomains: AUTH_API,
      disallowedRoutes: ['http://localhost:8096/login']}
     })*/
  ],
  providers: [authInterceptorProviders, AuthGaurdService],
  bootstrap: [AppComponent]
})
export class AppModule { }
