import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {TestService} from '../test.service';
import {Test} from '../model/test';
import {Role} from '../model/role';

@Component({
  selector: 'app-test-list',
  templateUrl: './test-list.component.html',
  styleUrls: ['./test-list.component.css']
})
export class TestListComponent implements OnInit{
  tests: Test[] = [];
  selectedTestId: number;
  selectedTestName: string;
  subjectId: number;
  visible = true;
  role = Role.Tutor;
  createComponentVisible = false;
  constructor(
    private route: ActivatedRoute,
    private testService: TestService
  ) {
    route.params.subscribe(params => { this.subjectId = params.id; });
  }
ngOnInit(): void {
    this.getTests();
    console.log(this.subjectId);
}
  getTests(): void {
    this.testService.getTests(this.subjectId)
      .subscribe(
        tests => this.tests = tests.testList,
        error => console.log(error)
      );
  }

  passTest(id: number, name: string): void{
    this.selectedTestId = id;
    this.selectedTestName = name;
    this.visible = false;
  }
  setTestListComponentVisible(): void{
    this.visible = true;
    this.createComponentVisible = false;
  }
  isTutor(): boolean{
    return this.role === Role.Tutor;
  }
  openCreateTestComponent(): void{
    this.createComponentVisible = true;
  }
}
