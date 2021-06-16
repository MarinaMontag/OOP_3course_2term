import { Component, OnInit } from '@angular/core';
import {FullTest} from '../_model/full-test';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../_services/user.service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-pass-test',
  templateUrl: './pass-test.component.html',
  styleUrls: ['./pass-test.component.css']
})
export class PassTestComponent implements OnInit {
  test: FullTest;
  result: number;
  visible = true;
  goBack(): void{
    this.router.navigate(['/subject/' + this.test.subjectId]);
  }
  constructor(
    private service: UserService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }
  ngOnInit(): void {
    console.log(this.test);
    this.route.params.subscribe(
      params => {
        this.service.getTest(params.id).subscribe(
          res => {
            console.log(res);
            res = JSON.parse(res);
            this.test = new FullTest(res.id, res.subjectId, res.name, res.description, res.questions);
          },
          error => {
            if (error instanceof HttpErrorResponse){
              if (error.status === 401){
                this.router.navigate(['/login']);
              }
            }
          }
        );
      }
    );
  }
  onSelect(questionNum: number, answerNum: number): void{
    const id = this.test.questions[questionNum].answers[answerNum].id;
    this.test.questions[questionNum].answers.forEach((answer) => {
        answer.selected = answer.id === id;
      }
    );
  }
  setResult(): void{
    this.result = 0;
    this.test.questions.forEach((question) =>
    {
      question.answers.forEach((answer) =>
      {
        if (answer.selected === answer.correctness && answer.correctness === true) {
          this.result++;
          answer.selected = false;
        }
      });
    });
    console.log(this.result);
    this.visible = false;
  }
  setTestComponentVisible(): void{
    this.visible = true;
  }
}
