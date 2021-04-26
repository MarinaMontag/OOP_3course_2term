import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {TestService} from '../test.service';
import {Test} from '../test';
import {Location} from '@angular/common';

@Component({
  selector: 'app-test-list',
  templateUrl: './test-list.component.html',
  styleUrls: ['./test-list.component.css']
})
export class TestListComponent implements OnInit{
  tests: Test[] = [];
  subjectId: number;
  constructor(
    private route: ActivatedRoute,
    private testService: TestService,
    private location: Location
  ) {
    route.params.subscribe(params => { this.subjectId = params.id; });
  }
ngOnInit(): void {
    this.getTests();
}
  getTests(): void {
    this.testService.getTests(this.subjectId)
      .subscribe(
        tests => this.tests = tests.testList,
        error => console.log(error)
      );
  }

  passTest(id: number): void{
    this.location.back();
  }
}
