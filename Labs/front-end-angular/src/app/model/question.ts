import {Answer} from './answer';

export class Question{
  id: number;
  testId: number;
  text: string;
  answerList: Answer[];
}
