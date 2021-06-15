import { Component, OnInit } from '@angular/core';
import {Subject} from '../_model/subject';
import {UserService} from '../_services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  errorMessage = '';
  subjects: Subject[] = [];
  constructor(private service: UserService) {
  }

  ngOnInit(): void {
    this.service.getSubjects().subscribe(
      data => {
        data = JSON.parse(data);
        this.subjects = data.subjects;
        console.log(data);
        console.log(data.subjects);
      },
      err => this.errorMessage = err.error.message
    );
  }


}
