import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Hotel} from '../../model/hotel.component';
import {HotelService} from '../../_services/hotel.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-hotel-list',
  templateUrl: './hotel-list.component.html',
  styleUrls: ['./hotel-list.component.css']
})
export class HotelListComponent implements OnInit {
  hotels: Observable<Hotel[]>;

  constructor(private hotelService: HotelService, private router: Router) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.hotels = this.hotelService.viewAllHotel();
  }

  removeHotel(id_hotel: number) {
    this.hotelService.removeHotel(id_hotel)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  hotelDetails(id_hotel: number) {
    this.router.navigate(['hoteldetails', id_hotel]);
  }

  modifyHotel(id_hotel: number) {
    this.router.navigate(['updatehotel', id_hotel]);
  }
}
