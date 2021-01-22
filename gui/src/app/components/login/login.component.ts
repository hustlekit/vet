import { Component, OnInit } from '@angular/core';
import {LoginService} from '../../services/login/login.service';
import {NgForm} from '@angular/forms';
import {ILogin} from '../../model/ilogin';
import {StateService} from '../../services/state/state.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private loginService: LoginService,
    private stateService: StateService
  ) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm): void {
    const login: ILogin = {
      login: form.value.login,
      pin: form.value.pin
    };
    this.stateService.ownList = true;
    this.loginService.login(login);
  }

}
