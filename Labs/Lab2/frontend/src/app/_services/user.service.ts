import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FullTest} from '../_model/full-test';

const GET_SUBJECTS_URL = 'http://localhost:8081/api/subjects';
const GET_TEST_URL = 'http://localhost:8081/api/test';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  getSubjects(): Observable<any>{
    return this.http.get(GET_SUBJECTS_URL, {responseType: 'text'});
  }
  getSubjectTests(subjectId: number): Observable<any>{
    return this.http.get(GET_SUBJECTS_URL + '/' + subjectId, {responseType: 'text'});
  }
  getTest(testId: bigint): Observable<any>{
    return this.http.get(GET_TEST_URL + '/' + testId, {responseType: 'text'});
  }
  sendTest(test: FullTest): Observable<any>{
    return this.http.post(GET_TEST_URL, test, httpOptions);
  }
}
