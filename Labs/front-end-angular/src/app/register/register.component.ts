import {Component, OnInit} from '@angular/core';
import {Role} from '../model/role';
import {User} from '../model/user';
import {AuthService} from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerUserData = new User('', '', '', '', null);
  constructor(private authService: AuthService) { }
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
     res => console.log(res),
     error => console.log(error)
   );
  }

  setRole(role: string): void{
    if (role === 'student') {
      this.setStudent();
    }
    else {
      this.setTutor();
    }
  }

}
