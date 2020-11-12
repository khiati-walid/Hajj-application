import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VolService {

  private baseUrl = 'https://a5ceb866d269.ngrok.io/api/vols';

  constructor(private http: HttpClient) { }

  getvol(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createVol(vol: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, vol);
  }

  updateVol(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteVol(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getVolsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getVolsByAge(age: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/age/${age}`);
  }
  getVolsByLieu(lieu: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/lieu/${lieu}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }
}