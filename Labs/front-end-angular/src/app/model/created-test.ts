import {Question} from './question';

export class CreatedTest{
  subjectId: number;
  name: string;
  description: string;
  questions: Question[];
}
