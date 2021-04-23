import { Component, OnInit } from '@angular/core';
import {User} from '../model/user';
import {AuthService} from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginUserData = new User('', '', '', '', null);
  constructor(private auth: AuthService) { }
  ngOnInit(): void {
  }
  login(): void {
    this.auth.loginUser(this.loginUserData).subscribe(
      res => {
        console.log(res);
      },
      error => {
        console.log(error);
        if (error.statusText === 'Unknown Error') {
          console.log('Unknown Error');
        }
      }
    );
  }
}
