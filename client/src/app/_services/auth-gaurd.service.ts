import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService {

  constructor(
    private authService: AuthService,
    private router: Router) { }

  canActivate() {
    if (this.authService.isLoggedIn())
      return true;
    this.router.navigate(['/']);
    return false;
  }

}
