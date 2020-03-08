import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {AdminUserListComponent} from "./admin-user-list/admin-user-list.component";
import {ReactiveFormsModule} from "@angular/forms";



const routes: Routes = [
  {
    path: '',
    redirectTo: 'list'
  },
  {
    path: 'list',
    component: AdminUserListComponent
  }
];

@NgModule({
  declarations: [
    AdminUserListComponent
  ],
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    ReactiveFormsModule
  ]
})
export class UserModule { }
