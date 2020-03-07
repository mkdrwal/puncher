import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {UserData} from "../interface/user-data";

@Injectable({
  providedIn: 'root'
})
export class UserStorageService {
  public user = new BehaviorSubject<UserData>(null);

  constructor() {
    this.init();
  }

  private init() {
    const userData = localStorage.getItem('user-data');

    if (null !== userData) {
      this.user.next((<UserData>JSON.parse(userData)));
    }
  }

  public save(userData: UserData) {
    this.user.next(userData);
    localStorage.setItem('user-data', JSON.stringify(userData));
  }
}
