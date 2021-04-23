import { Component, OnInit } from '@angular/core';
import {SubjService} from '../subj.service';
import {Subject} from '../model/subject';

@Component({
  selector: 'app-sub-board',
  templateUrl: './sub-board.component.html',
  styleUrls: ['./sub-board.component.css']
})
export class SubBoardComponent implements OnInit {
  subjects: Subject[] = [];
  constructor(private service: SubjService) {
  }

  ngOnInit(): void {
    this.service.getSubjects().subscribe(
      subjects => this.subjects = subjects,
      error => console.log(error)
    );
  }

}
