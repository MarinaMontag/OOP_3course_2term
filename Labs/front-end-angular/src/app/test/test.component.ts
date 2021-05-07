import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Question} from '../model/question';
import {TestService} from '../test.service';


@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit{
  @Input() testId: number;
  @Input() testName: string;
  // tslint:disable-next-line:no-output-on-prefix
  @Output() back = new EventEmitter<boolean>();
  questions: Question[] = [];
  answers: number[];
  result: number;
  visible = true;
  goBack(): void{
    this.back.emit(true);
  }
  constructor(
    private service: TestService
  ) { }
  ngOnInit(): void {
    this.service.getTest(this.testId).subscribe(
      res => {
        this.questions = res.questions;
        console.log(res.questions);
      },
      error => console.log(error)
    );
  }
  onSelect(questionNum: number, answerNum: number): void{
    const id = this.questions[questionNum].answerList[answerNum].id;
    this.questions[questionNum].answerList.forEach((answer) => {
        answer.selected = answer.id === id;
      }
    );
  }
  setResult(): void{
    this.result = 0;
    this.questions.forEach((question) =>
    {
      question.answerList.forEach((answer) =>
      {
        if (answer.selected === answer.correctness && answer.correctness === true) {
          this.result++;
        }
      });
    });
    this.visible = false;
  }
  setTestComponentVisible(): void{
    this.visible = true;
  }
}
