import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {UserStorageService} from "../service/user-storage.service";

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

  constructor(
    private userStorageService: UserStorageService
  ) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token = this.userStorageService.user.getValue()?.token;

    if (token) {
      request = request.clone({
        headers: request.headers
          .set('Authorization', 'Bearer ' + token)
      });
    }

    return next.handle(request);
  }
}
