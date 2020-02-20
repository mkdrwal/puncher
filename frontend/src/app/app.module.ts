import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NotFoundComponent } from './auth/not-found/not-found.component';
import {LoginComponent} from "./auth/login/login.component";
import {ReactiveFormsModule} from "@angular/forms";
import {MatSidenavModule} from "@angular/material/sidenav";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {CatchingMessageInterceptor} from "./core/interceptor/catching-message.interceptor";
import {MatSnackBarModule} from "@angular/material/snack-bar";


@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatSidenavModule,
    HttpClientModule,
    MatSnackBarModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: CatchingMessageInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
