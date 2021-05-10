import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TestService} from '../test.service';
import {Test} from '../model/test';
import {Role} from '../model/role';
import jwtDecode from 'jwt-decode';
import {AuthGuard} from '../auth.guard';

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
  role: Role;
  createComponentVisible = false;
  constructor(
    private route: ActivatedRoute,
    private testService: TestService,
    private router: Router,
    private guard: AuthGuard
  ) {
    route.params.subscribe(params => {
      this.subjectId = params.id;
    });
  }
ngOnInit(): void {
    this.getTests();
    if (this.role === undefined) {
    // @ts-ignore
    const decodeRole = jwtDecode(localStorage.getItem('token')).sub;
    if (decodeRole === 'STUDENT') {
      this.role = Role.Student;
    }
    else if (decodeRole === 'TUTOR') {
      this.role = Role.Tutor;
    }
    else
    {
      this.role = null;
    }
  }
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
    this.visible = !this.guard.canActivate();
  }
  setTestListComponentVisible(): void{
    this.visible = true;
    this.createComponentVisible = false;
  }
  isTutor(): boolean{
    if (this.role != null) {
      // tslint:disable-next-line:triple-equals
    return this.role.valueOf() == Role.Tutor;
    }
    else {
      return false;
    }
  }
  openCreateTestComponent(): void{
    this.createComponentVisible = this.guard.canActivate();
  }
}
