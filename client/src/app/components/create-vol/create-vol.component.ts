import {Component, OnInit} from '@angular/core';
import {Vol} from '../../model/vol.component';
import {VolService} from '../../_services/vol.service';

@Component({
    selector: 'create-vol',
    templateUrl: './create-vol.component.html',
    styleUrls: ['./create-vol.component.css']
})

export class CreateCustomerComponent implements OnInit {

    vol: Vol = new Vol();
    submitted = false;

    constructor(private customerService: VolService) {
    }

    ngOnInit() {
    }

    newCustomer(): void {
        this.submitted = false;
        this.vol = new Vol();
    }

    save() {

        this.customerService.createVol(this.vol)
            .subscribe(data => console.log(data), error => console.log(error));
        this.vol = new Vol();
    }

    onSubmit() {
        this.submitted = true;
        this.save();
    }
}
