import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private Url = 'http://localhost:9092/reservation';
  constructor(private http: HttpClient) {
  }

  viewReservation(id_reservation: number): Observable<any> {
    return this.http.get(`${this.Url}/viewReservation/${id_reservation}`);
  }

  addReservation(reservation: Object): Observable<Object> {
    return this.http.post(`${this.Url}/addReservation`, reservation);
  }

  modifyReservation(id_reservation: number, value: any): Observable<Object> {
    return this.http.put(`${this.Url}/updateReservation`, value);
  }

  removeReservation(id_reservation: number): Observable<any> {
    return this.http.delete(`${this.Url}/deleteReservation/${id_reservation}`, {responseType: 'text'});
  }

  viewAllReservation(): Observable<any> {
    return this.http.get(`${this.Url}/allReservation`);
  }

}
