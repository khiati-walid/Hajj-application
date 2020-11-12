import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponentComponent} from './components/home-component/home-component.component';
import {MedecinComponent} from './components/medecin/medecin.component';
import {LoginComponent} from './components/login/login.component';
import {BoardAdminComponent} from './components/board-admin/board-admin.component';
import {TirageComponent} from './components/tirage/tirage.component';
import {VolComponent} from './components/vol/vol.component';

import {HotelListComponent} from './components/hotel-list/hotel-list.component';

import { CustomersListComponent } from './components/vol-list/vol-list.component';
import { CreateCustomerComponent } from './components/create-vol/create-vol.component';
import { SearchCustomersComponent } from './components/search-vol/search-vol.component';

import { CreateHotelComponent } from './components/create-hotel/create-hotel.component';
import { UpdateHotelComponent } from './components/update-hotel/update-hotel.component';
import { HotelDetailsComponent } from './components/hotel-details/hotel-details.component';

const routes: Routes = [
  {path: '' , component : HomeComponentComponent},
  {path: 'medecin' , component : MedecinComponent},
  {path: 'login' , component : LoginComponent},
  {path: 'tirage' , component : TirageComponent},
  {path: 'admin' , component : BoardAdminComponent},
  {path: 'vol' , component : VolComponent}, 
  {path: 'hotels', component: HotelListComponent},

  { path: 'voll', component: CustomersListComponent },
  { path: 'add', component: CreateCustomerComponent },
 
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'hotels', component: HotelListComponent},
 
  { path: 'vol', component: CustomersListComponent },
  { path: 'add', component: CreateCustomerComponent },
  { path: 'addhotel', component: CreateHotelComponent },
  { path: 'updatehotel/:id_hotel', component: UpdateHotelComponent },
  { path: 'hoteldetails/:id_hotel', component: HotelDetailsComponent },
  { path: 'findbyage', component: SearchCustomersComponent },
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
