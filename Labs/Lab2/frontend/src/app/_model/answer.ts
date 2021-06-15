export class Answer {
  constructor(public id: number,
              public text: string,
              public correctness: boolean) {
  }
  selected: boolean;
}
