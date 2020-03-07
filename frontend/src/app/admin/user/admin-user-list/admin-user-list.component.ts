import { Component, OnInit } from '@angular/core';
import {EnvService} from "../../../core/service/env.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-admin-user-list',
  templateUrl: './admin-user-list.component.html',
  styleUrls: ['./admin-user-list.component.scss']
})
export class AdminUserListComponent implements OnInit {

  constructor(
    private envService: EnvService,
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {
    this.httpClient.get(this.envService.getApiUrl('/user/list')).subscribe(value => {
      console.log(value);
    },
      error => {
        console.log(error)
      });
  }

}
