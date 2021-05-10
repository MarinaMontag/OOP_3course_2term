import {Component, OnInit} from '@angular/core';
import {Role} from '../model/role';
import {User} from '../model/user';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';
import jwtDecode from 'jwt-decode';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerUserData = new User('', '', '', '', null);
  constructor(private authService: AuthService,
              private router: Router) { }
  ngOnInit(): void {
  }

  setStudent(): void{
    this.registerUserData.role = Role.Student;
  }
  setTutor(): void{
    this.registerUserData.role = Role.Tutor;
  }
  register(role: string): void{
    this.setRole(role);
    this.authService.registerUser(this.registerUserData).subscribe(
     res => {
       localStorage.setItem('token', res.token);
       this.router.navigate(['/subject']);
     },
     error => console.log(error)
   );
  }

  setRole(role: string): void{
    if (role === 'STUDENT') {
      this.setStudent();
    }
    else if (role === 'TUTOR'){
      this.setTutor();
    }
  }

}
