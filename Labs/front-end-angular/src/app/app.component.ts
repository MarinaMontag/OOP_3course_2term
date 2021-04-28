import { Component } from '@angular/core';
import {Role} from './model/role';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front-end-angular';
  loggedIn = false;
  role = Role.Student;
  setLoggedIn(): void{
    this.loggedIn = true;
  }
}
