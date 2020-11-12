import {Component, OnInit} from '@angular/core';
import {AuthService} from './_services/auth.service';
import {Router} from '@angular/router';
import {TokenStorageService} from './_services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'Project';
  stat = '../../assets/HAJJ1.jpg';
  isLoggedIn: boolean;

  constructor(private authService: AuthService, private router: Router
  ) {
    this.isLoggedIn = authService.isLoggedIn();
   }
  ngOnInit(): void {
    this.authService.notifyObservable$.subscribe((res) => {
      this.isLoggedIn = res;
    });
  }
  logout() {
    this.authService.logout();
    this.isLoggedIn = false;
    this.router.navigate(['/login']);
  }

  login() {
    console.log("isLogin");
    this.isLoggedIn = true;
  }
}
