import { Injectable } from '@angular/core';
import {IUser} from '../../model/iuser';

@Injectable({
  providedIn: 'root'
})
export class StateService {

  loggedUser: IUser;
  ownList: boolean;

  constructor() { }
}
