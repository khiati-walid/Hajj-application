import { Component, OnInit } from '@angular/core';
import { Vol } from '../../model/vol.component';
import { VolService } from '../../_services/vol.service';

@Component({
  selector: 'search-customers',
  templateUrl: './search-vol.component.html',
  styleUrls: ['./search-vol.component.css']
})
export class SearchCustomersComponent implements OnInit {

  age: number;
  customers: Vol[];

  constructor(private dataService: VolService) { }

  ngOnInit() {
    this.age = 0;
  }

  private searchCustomers() {
    this.dataService.getVolsByAge(this.age)
      .subscribe(customers => this.customers = customers);
  }

  onSubmit() {
    this.searchCustomers();
  }
}
