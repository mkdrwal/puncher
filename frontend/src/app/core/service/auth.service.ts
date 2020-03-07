import { Injectable } from '@angular/core';
import {UserStorageService} from "./user-storage.service";
import {EnvService} from "./env.service";
import {HttpClient} from "@angular/common/http";
import {UserData} from "../interface/user-data";
import {throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private userStorageService: UserStorageService,
    private envService: EnvService,
    private httpClient: HttpClient
  ) { }


  public login(data: {username: string; password: string}) {
    this.httpClient.post(this.envService.getApiUrl('login'), data).subscribe(
      (value) => {
        this.userStorageService.save((<UserData>value));
      },
      (error) => {
        console.log(error);
        return throwError("Invalid data");
      }
    )
  }
}
