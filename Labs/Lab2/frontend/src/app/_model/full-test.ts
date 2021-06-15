import {Question} from './question';

export class FullTest{
  constructor(public id: bigint,
              public name: string,
              public description: string,
              public questions: Question[]) {}
}
