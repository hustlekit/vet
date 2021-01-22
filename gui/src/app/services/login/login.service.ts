import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Router} from '@angular/router';
import {StateService} from '../state/state.service';
import {ILogin} from '../../model/ilogin';
import {IUser} from '../../model/iuser';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl: string = environment.APIEndpoint;

  constructor(
    private http: HttpClient,
    private router: Router,
    private stateService: StateService
  ) { }

  login(login: ILogin): void {
    const url = this.baseUrl + '/user/login';
    this.http.post(url, login, httpOptions)
      .subscribe(result => {
        const user: IUser = result as IUser;
        this.stateService.loggedUser = user;
        this.router.navigate(['/appointment-list']);
      });
  }
}
