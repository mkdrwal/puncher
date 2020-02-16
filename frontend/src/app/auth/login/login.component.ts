import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {EnvService} from "../../core/service/env.service";
import {HttpClient} from "@angular/common/http";

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
    private envService: EnvService,
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {
  }

  login() {
    console.log(this.envService.getApiUrl('login'));

    this.httpClient.post(this.envService.getApiUrl('login'), {"username": "admin", "password": "admin"}).subscribe(value => {
      console.log(value)
    })
  }
}
