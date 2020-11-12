import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-component',
  templateUrl: './home-component.component.html',
  styleUrls: ['./home-component.component.css']
})
export class HomeComponentComponent implements OnInit {
  hajImg = '../../assets/hadj.PNG';
  cap1 = '../../assets/cap1.png';
  cap2 = '../../assets/cap2.png';
  cap3 = '../../assets/cap3.png';
  cap5 = '../../assets/cap5.png';
  constructor() { }

  ngOnInit(): void {
  }

}
