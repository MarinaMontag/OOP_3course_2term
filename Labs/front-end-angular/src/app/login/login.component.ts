import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {User} from '../model/user';
import {AuthService} from '../auth.service';
import {Role} from '../model/role';

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
        this.loginUserData = res;
        if (res.role === 'STUDENT'){
          this.loginUserData.role = Role.Student;
        }
        else {
          this.loginUserData.role = Role.Tutor;
        }
        console.log(this.loginUserData);
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
