import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpResponse
} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {MatSnackBar} from "@angular/material/snack-bar";
import {catchError, finalize, map, tap} from "rxjs/operators";

@Injectable()
export class CatchingMessageInterceptor implements HttpInterceptor {

  constructor(
    private matSnackBar: MatSnackBar
  ) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    return next.handle(request).pipe(
      tap(event => {
        if (event instanceof HttpResponse && event.body?.message) {
          this.showBar(event.body.message);
        }
        return of(event);
      }),
      catchError(err => {
        if(err.error && err.error.message) {
          this.showBar(err.error.message);
        }

        return of(err);
      })
    );
  }

  private showBar(message: string) {
    this.matSnackBar.open(message)
  }
}
