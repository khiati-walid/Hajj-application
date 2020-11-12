import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class PellerinService {
  private Url = 'https://8ae67c3c833a.ngrok.io/pellerin';
  constructor(private http: HttpClient) {
  }

  viewPellerin(numPasseport: number): Observable<any> {
    return this.http.get(`${this.Url}/viewPellerin/${numPasseport}`);
  }

  addPellerin(pellerin: Object): Observable<Object> {
    return this.http.post(`${this.Url}/addPellerin`, pellerin);
  }

  modifyPellerin(numPasseport: number, value: any): Observable<Object> {
    return this.http.put(`${this.Url}/updatePellerin`, value);
  }

  removePellerin(numPasseport: number): Observable<any> {
    return this.http.delete(`${this.Url}/deletePellerin/${numPasseport}`, {responseType: 'text'});
  }

  viewAllPellerin(): Observable<any> {
    return this.http.get(`${this.Url}/allPellerin`);
  }

}
