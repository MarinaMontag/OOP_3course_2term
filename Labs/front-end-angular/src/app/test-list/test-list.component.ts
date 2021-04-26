import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {TestService} from '../test.service';
import {Test} from '../test';

@Component({
  selector: 'app-test-list',
  templateUrl: './test-list.component.html',
  styleUrls: ['./test-list.component.css']
})
export class TestListComponent implements OnInit{
  tests: Test[] = [];
  constructor(
    private route: ActivatedRoute,
    private testService: TestService
  ) {}
ngOnInit(): void {
  this.getTests();
}
  getTests(): void {
    const subjectId = Number(this.route.snapshot.paramMap.get('id'));
    this.testService.getTests(subjectId)
      .subscribe(
        tests => this.tests = tests.testList,
        error => console.log(error)
      );
  }
  passTest(id: number): void{
  }
}
