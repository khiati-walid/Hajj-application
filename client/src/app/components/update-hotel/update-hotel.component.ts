import { Component, OnInit } from '@angular/core';
import { Hotel } from '../../model/hotel.component';
import { ActivatedRoute, Router } from '@angular/router';
import {HotelService} from '../../_services/hotel.service';

@Component({
  selector: 'app-update-hotel',
  templateUrl: './update-hotel.component.html',
  styleUrls: ['./update-hotel.component.css']
})
export class UpdateHotelComponent implements OnInit {
  id_hotel: number;
  hotel: Hotel;
  constructor(private route: ActivatedRoute,private router: Router,
    private hotelService: HotelService) { }

  ngOnInit(){
    this.hotel=new Hotel();
    this.id_hotel=this.route.snapshot.params['id_hotel'];
    this.hotelService.viewHotel(this.id_hotel)
      .subscribe(data => {
        console.log(data)
        this.hotel = data;
      }, error => console.log(error));
  }

  modifyHotel() {
    this.hotelService.modifyHotel(this.id_hotel, this.hotel)
      .subscribe(data => console.log(data), error => console.log(error));
    this.hotel = new Hotel();
    this.gotoList();
  }

  onSubmit() {
    this.modifyHotel();
  }

  gotoList() {
    this.router.navigate(['/hotels']);
  }
}

