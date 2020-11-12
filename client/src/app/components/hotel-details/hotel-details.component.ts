import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HotelService} from '../../_services/hotel.service';
import {Hotel} from "../../model/hotel.component";

@Component({
  selector: 'app-hotel-details',
  templateUrl: './hotel-details.component.html',
  styleUrls: ['./hotel-details.component.css']
})
export class HotelDetailsComponent implements OnInit {
  id_hotel: number;
  hotel: Hotel;

  constructor(private route: ActivatedRoute, private router: Router,
              private hotelService: HotelService) {
  }

  ngOnInit() {
    this.hotel = new Hotel();

    this.id_hotel = this.route.snapshot.params['id_hotel'];

    this.hotelService.viewHotel(this.id_hotel)
      .subscribe(data => {
        console.log(data);
        this.hotel = data;
      }, error => console.log(error));
  }

  list() {
    this.router.navigate(['hotels']);
  }
}

