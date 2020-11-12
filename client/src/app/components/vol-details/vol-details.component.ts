import { Component, OnInit, Input } from '@angular/core';
import { VolService } from '../../_services/vol.service';
import { Vol } from '../../model/vol.component';

import { CustomersListComponent } from '../vol-list/vol-list.component';

@Component({
  selector: 'vol-details',
  templateUrl: './vol-details.component.html',
  styleUrls: ['./vol-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
   show:boolean=false;
  @Input() customer: Vol;

  constructor(private customerService: VolService, private listComponent: CustomersListComponent) { }

  ngOnInit() {
  }
showbuuton(){
  this.show=!this.show;
}
  update() {
    this.customerService.updateVol(this.customer.id,
      { datedepart: this.customer.datedepart, datedarrive: this.customer.datedarrive,
        Lieudepart: this.customer.lieudepart ,agance :this.customer.agance,avion : this.customer.avion,
        lieudarrive: this.customer.lieudarrive,
        age:this.customer.age,
         active: true })
      .subscribe(
        data => {
          console.log(data);
          this.customer = data as Vol;
        },
        error => console.log(error));
  }

  deleteVoll() {
    this.customerService.deleteVol(this.customer.id)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }
}
