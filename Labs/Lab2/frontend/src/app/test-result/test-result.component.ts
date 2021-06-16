import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-test-result',
  templateUrl: './test-result.component.html',
  styleUrls: ['./test-result.component.css']
})
export class TestResultComponent implements OnInit {
  @Input()result: number;
  @Input()maxResult: number;
  @Input()testName: string;
  @Output() restart = new EventEmitter<boolean>();
  @Output() backToTests = new EventEmitter<boolean>();
  constructor() { }
  ngOnInit(): void {
  }
  repassTest(): void{
    this.restart.emit(true);
  }
  goBackToTests(): void{
    this.backToTests.emit(true);
  }
}
