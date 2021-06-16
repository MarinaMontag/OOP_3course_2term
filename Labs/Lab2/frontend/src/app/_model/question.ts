import {Answer} from './answer';

export class Question{
  constructor(public id: number,
              public text: string,
              public answers: Answer[]) {
  }
}
