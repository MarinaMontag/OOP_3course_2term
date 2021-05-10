import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from './model/user';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private registerUrl = 'http://localhost:8081/register';
  private loginUrl = 'http://localhost:8081/login';
  constructor(private http: HttpClient) {
  }
  registerUser(user: User): Observable<any>{
    return this.http.post(this.registerUrl, JSON.stringify(user));
  }
  loginUser(user: User): Observable<any>{
    return this.http.post(this.loginUrl, JSON.stringify(user));
  }
  loggedIn(): boolean{
    return !!localStorage.getItem('token');
  }
}
