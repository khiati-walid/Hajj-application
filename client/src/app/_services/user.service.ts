import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL = 'http://8ae67c3c833a.ngrok.io';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization' :  localStorage.getItem('token')
    }),
  };
  constructor(private http: HttpClient) { }

  getAllParticipants(){
    return this.http.get(API_URL + '/participants', this.httpOptions );
  }

  getPelerinParticipants(numberOfParticipant) {

    return this.http.post(API_URL + '/tirage' , { "nb": numberOfParticipant}, this.httpOptions);
  }

  getPelerinFiltrage(nb: number, age: number) {
    return this.http.post(API_URL + '/filtrage' , { "nb": nb, "age": age}, this.httpOptions);
  }
}
