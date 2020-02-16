import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {EnvService} from "./service/env.service";



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  exports: [
    EnvService
  ]
})
export class CoreModule { }
