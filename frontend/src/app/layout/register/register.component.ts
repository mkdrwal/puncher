import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/core/service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm = new FormGroup({
    username: new FormControl(),
    password: new FormControl(),
    email: new FormControl()
  });

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  register() {
    try {
      this.authService.register(this.registerForm.getRawValue());
    } catch (e) {
      console.error(e);
    }
  }

}
