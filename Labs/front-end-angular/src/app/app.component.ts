import {Component, OnInit} from '@angular/core';
import jwtDecode from 'jwt-decode';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  title = 'front-end-angular';
  loggedIn = false;
  setLoggedIn(): void{
    this.loggedIn = true;
  }
  setLoggedOut(): void{
    this.loggedIn = false;
  }
  constructor() {
    if (localStorage.getItem('token') != null){
      console.log(jwtDecode(localStorage.getItem('token')));
      this.setLoggedIn();
    }
  }
  ngOnInit(): void {
    }
}
