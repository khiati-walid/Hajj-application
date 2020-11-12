import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { VolService } from '../../_services/vol.service';
import { Vol } from '../../model/vol.component';

@Component({
  selector: 'vol-list',
  templateUrl: './vol-list.component.html',
  styleUrls: ['./vol-list.component.css']
})
export class CustomersListComponent implements OnInit {
  selected:String=''; 
  customers: Observable<Vol[]>;
  
  selectchangehandler(event:any){
    this.selected=event.target.value;
  return event.target.value;}
  constructor(private customerService: VolService) { }

  ngOnInit() {
    this.reloadData();
  }
check(){

  this.customers = this.customerService.getVolsList();
  for (let vol in this.customers){
    console.log(vol)

  }
  

}
  deleteVol() {
    this.customerService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.customers = this.customerService.getVolsByLieu(this.selected)
  }
}
