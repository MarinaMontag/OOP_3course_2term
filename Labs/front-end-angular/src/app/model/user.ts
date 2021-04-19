import {IronEncrypt} from '../iron/iron-encrypt';
import {Role} from './role';

@IronEncrypt({dataClassPassword: ['top-secret']})
export class User{
  constructor(
    public firstName: string,
    public lastName: string,
    public email: string,
    public password: string,
    public role: Role
  ){}
}
