import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../_services/auth.service';


@Component({
  selector: 'app-vol',
  templateUrl: './vol.component.html',
  styleUrls: ['./vol.component.css']
})
export class VolComponent implements OnInit {
  Myform: FormGroup;
  constructor(private authService: AuthService) { }

  ngOnInit() {

    this.Myform = new FormGroup({
      num: new FormControl('', [Validators.required]),
      depart: new FormControl('', [Validators.required]),
      arrive: new FormControl('', [Validators.required]),
      lieuDepart: new FormControl('', [Validators.required]),
      lieuArrive: new FormControl('', [Validators.required]),
      agence: new FormControl('', [Validators.required]),
      avion: new FormControl('', [Validators.required]),
    });
  }

  // Getter to access form control
  get f(){
    return this.Myform.controls;
  }
  onSubmit() {
    this.authService.createVol(this.Myform.value).subscribe(
      data => {
        console.log(data);
        },
    );
  }

}
