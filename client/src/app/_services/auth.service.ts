import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse} from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
// import { AppError } from 'src/app/_common/app.error';
// import { NotFoundError } from 'src/app/_common/notfound.error';
import { JwtHelperService } from '@auth0/angular-jwt';
import {Subject, throwError} from 'rxjs';




const AUTH_API = 'http://8ae67c3c833a.ngrok.io';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  private notify = new Subject<any>();

  notifyObservable$ = this.notify.asObservable();
  constructor(private http: HttpClient) { }

  login(data){
    const jwtHelper = new JwtHelperService();
    return this.http.post(AUTH_API + '/login', data, {observe: 'response' as 'body'})
      .pipe(map((res: HttpResponse<any>) => {
        console.log(res);
        const token = res.headers.get('authorization');
        if (res.status === 200 && token) {
            localStorage.setItem('token', token);
            console.log(token);
            if (jwtHelper.decodeToken(token).roles[0] === 'ADMIN') {
              return true;
            } else {
              return true;
            }
          }
        return false;
        }),
      );
  }

  public notifyOther(data: any) {
    if (data) {
      this.notify.next(data);
    }
  }


  logout(){
    localStorage.removeItem('token');
  }

  isLoggedIn() {
    const jwtHelper = new JwtHelperService();
    const token = localStorage.getItem('token');

    if (!token) {
      return false;
    }

    const isExpired = jwtHelper.isTokenExpired(token);

    return !isExpired;
  }

  getPelerin(){
    return this.http.post(AUTH_API + '/tirage', this.httpOptions );
  }
  createVol(data){
    return this.http.post(AUTH_API + '/add-vol', data, this.httpOptions);
  }
  /*errorHandler(error: HttpErrorResponse) {
    if (error.status === 403) {
      return throwError(new NotFoundError());
    } else {
      return throwError(new AppError());
    }
  }*/

}


