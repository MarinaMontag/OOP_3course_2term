import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FullTest} from '../_model/full-test';
import {UserService} from '../_services/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Question} from '../_model/question';
import {Answer} from '../_model/answer';

@Component({
  selector: 'app-create-test',
  templateUrl: './create-test.component.html',
  styleUrls: ['./create-test.component.css']
})
export class CreateTestComponent implements OnInit {
  subjectId: number;
  questionForm: FormGroup;
  testInfoForm: FormGroup;
  test: FullTest;
  enterTestInfo = true;
  enterQuestions = false;
  constructor(private fb: FormBuilder,
              private http: UserService,
              private route: ActivatedRoute,
              private router: Router){
    this.questionForm =  this.createQuestionNewFormGroup();
    this.testInfoForm = this.createTestInfoFormGroup();
    this.route.params.subscribe(params => {
      this.subjectId = params.id;
    });
  }
  cancel(): void{
    this.test = new FullTest(null, this.subjectId, '', '', []);
    this.router.navigate(['/subject/' + this.subjectId]);
  }
  createQuestionNewFormGroup(): FormGroup{
    return this.fb.group({
      question: ['', [Validators.required]],
      answers: this.fb.array([
        this.fb.control(''),
        this.fb.control('')
      ]),
      indexOfCorrectAnswer: ['1', [Validators.required]]
    });
  }
  createTestInfoFormGroup(): FormGroup{
    return this.fb.group({
      name: ['', [Validators.required]],
      description: ['', [Validators.required]]
    });
  }
  get answers(): FormArray {
    return this.questionForm.get('answers') as FormArray;
  }
  addAnswer(): void {
    this.answers.push(this.fb.control(''));
  }
  addQuestion(): void{
    const question = new Question(null, '', []);
    question.text = this.questionForm.controls.question.value;
    question.answers = [];
    const answersArray = this.questionForm.controls.answers.value;
    for (const answer of answersArray){
      question.answers.push(new Answer(null, answer, null));
    }
    this.setAnswersCorrectness(question);
    this.test.questions.push(question);
    this.questionForm = this.createQuestionNewFormGroup();
  }

  setAnswersCorrectness(question: Question): void{
    for (let i = 0; i < question.answers.length; i++){
      if ((i + 1) === +this.questionForm.controls.indexOfCorrectAnswer.value){
        question.answers[i].correctness = true;
      }
      else {
        question.answers[i].correctness = false;
      }
    }
  }

  addQuestions(): void{
    this.enterTestInfo = false;
    this.enterQuestions = true;
    this.test.name = this.testInfoForm.controls.name.value;
    this.test.description = this.testInfoForm.controls.description.value;
  }
  save(): void{
    this.addQuestion();
    this.http.sendTest(this.test).subscribe(
      resp => console.log(resp),
      error => console.log(error)
    );
    this.test = new FullTest(null, this.subjectId, '', '', []);
    this.router.navigate(['/subject/' + this.subjectId]);
  }

  ngOnInit(): void {
    this.test = new FullTest(null, this.subjectId, '', '', []);
  }
}
