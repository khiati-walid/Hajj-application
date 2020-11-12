import { Component, OnInit } from '@angular/core';
import { UserService } from '../../_services/user.service';
import {AuthService} from '../../_services/auth.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  content = '';
  stat = '../../assets/HAJJ1.jpg';
  constructor(private userService: UserService, private authService: AuthService, private router: Router) {
    if (!authService.isLoggedIn()){
      this.router.navigate(['/login']);
    }
  }
  ngOnInit() {
  }
}
