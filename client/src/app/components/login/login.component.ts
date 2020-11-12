import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../_services/auth.service';
import { TokenStorageService } from '../../_services/token-storage.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  isLoggedIn = false;
  isLoginFailed = false;
  @Output() loginEvent = new EventEmitter<any>();
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router, private tokenStorage: TokenStorageService
  ) {  if (authService.isLoggedIn()){
    this.router.navigate(['/admin']);
  } }

  ngOnInit() {

    this.form = new FormGroup({
      email: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });


  }

  // Getter to access form control
  get f(){
    return this.form.controls;
  }

  onSubmit() {
    this.isLoggedIn = true;

    // stop here if form is invalid
    if (this.form.invalid) {
      return;
    }
    this.authService.login(this.form.value).subscribe(
      data => {

        if (data){
          this.authService.notifyOther(true);
          this.router.navigate(['/admin']);
           }
        else {
          this.isLoginFailed = true;
        }
      },
      err => {
        console.log(err);
        // this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

}
