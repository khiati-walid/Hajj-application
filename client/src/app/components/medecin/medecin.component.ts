import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-medecin',
  templateUrl: './medecin.component.html',
  styleUrls: ['./medecin.component.css']
})

export class MedecinComponent implements OnInit {
  raport = '../../assets/form.svg';

  constructor() { }

  ngOnInit(): void {
  }

}

