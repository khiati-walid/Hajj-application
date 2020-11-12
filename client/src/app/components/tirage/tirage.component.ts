import { Component, OnInit } from '@angular/core';
import {UserService} from '../../_services/user.service';
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-tirage',
  templateUrl: './tirage.component.html',
  styleUrls: ['./tirage.component.css']
})
export class TirageComponent implements OnInit {

  itemsArray = [];
  itemsPelerin = [];
  nmbrParticipant: FormControl = new FormControl('', Validators.required);
  nmbrfiltrage: FormControl = new FormControl('', Validators.required);
  age: FormControl = new FormControl('', Validators.required);
  constructor(private userService: UserService) {}
  ngOnInit() {
    this.userService.getAllParticipants().subscribe(res => {
      console.log(res);
      const result: any = res;
      if ( result && result.content){
        console.log(result);
        result.content.forEach(participant => {
       this.itemsArray.push(participant);
      });
      }
      console.log(res);
    // TODO get all participants
  });
  }

  tirage() {
    if(this.nmbrParticipant.valid){
    this.userService.getPelerinParticipants(this.nmbrParticipant.value).subscribe(res => {
      const items: any = res;
      this.itemsPelerin = [];
      items.forEach(item => {
        this.itemsPelerin.push(item);
        const index = this.itemsArray.findIndex(participant => participant.id === item.id);
        this.itemsArray.splice(index, 1);
      });
      console.log("endItem");

      console.log(res);
    });
    }else {
      alert("il faut remplire le nmbr d participant" );
    }
  }

  filtrage() {
    if (this.nmbrfiltrage.valid && this.age.valid){
    this.userService.getPelerinFiltrage(this.nmbrfiltrage.value, this.age.value).subscribe(res => {
      const items: any = res;
      this.itemsPelerin = [];
      items.forEach(item => {
        this.itemsPelerin.push(item);
        const index = this.itemsArray.findIndex(participant => participant.id === item.id);
        this.itemsArray.splice(index, 1);
      });
    });
  }else{
      alert("il faut remplire les champs" );
    } }
}
