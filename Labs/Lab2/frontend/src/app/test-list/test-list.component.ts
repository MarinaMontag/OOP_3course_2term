import { Component, OnInit } from '@angular/core';
import {UserService} from '../_services/user.service';
import {Test} from '../_model/test';
import {ActivatedRoute, Router} from '@angular/router';
import {TokenStorageService} from '../_services/token-storage.service';

@Component({
  selector: 'app-test-list',
  templateUrl: './test-list.component.html',
  styleUrls: ['./test-list.component.css']
})
export class TestListComponent implements OnInit {
  errorMessage = '';
  tests: Test[] = [];
  subjectId: number;
  roles: string[];
  isTutor = false;
  constructor( private route: ActivatedRoute,
               private router: Router,
               private userService: UserService,
               private tokenService: TokenStorageService) {
    const user = this.tokenService.getUser();
    if(user != null){
      this.roles = user.roles;
      this.isTutor = this.roles.includes('ROLE_TUTOR');
    }
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.subjectId = params.id;
    });
    this.userService.getSubjectTests(this.subjectId).subscribe(
      data => {
        data = JSON.parse(data);
        this.tests = data.tests;
        console.log(data);
        console.log(data.tests);
      },
      err => this.errorMessage = err.error.message
    );
  }
  passTest(id: bigint): void{
    this.router.navigate(['/test/' + id]);
  }
  openCreateTestComponent(): void{
    this.router.navigate(['/create/' + this.subjectId]);
  }
}
