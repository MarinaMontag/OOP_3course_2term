import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from './model/user';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private registerUrl = 'http://localhost:8081/register';
  constructor(private http: HttpClient) {
  }
  registerUser(user: User): Observable<any>{
    return this.http.post(this.registerUrl, user);
  }
}
