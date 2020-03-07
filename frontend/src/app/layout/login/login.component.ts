import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {EnvService} from "../../core/service/env.service";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../core/service/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm = new FormGroup({
    username: new FormControl(),
    password: new FormControl()
  });

  constructor(
    private authService: AuthService
  ) { }

  ngOnInit(): void {
  }

  login() {
    try {
      this.authService.login(this.loginForm.getRawValue());
    } catch (e) {
      console.error(e);
    }
  }
}
