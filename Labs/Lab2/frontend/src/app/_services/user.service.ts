import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const GET_SUBJECTS_URL = 'http://localhost:8081/api/subjects';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  getSubjects(): Observable<any>{
    return this.http.get(GET_SUBJECTS_URL, {responseType: 'text'});
  }
  // getStudentContent(): Observable<any>{
  //   return this.http.get(API_URL + 'student', {responseType: 'text'});
  // }
  // getTutorContent(): Observable<any>{
  //   return this.http.get(API_URL + 'tutor', {responseType: 'text'});
  // }
}
