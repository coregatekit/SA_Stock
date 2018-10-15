import {Component, OnInit} from '@angular/core';
import { RegisterService } from '../shared/register/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  genders: Array<any>;

  constructor(private registerService: RegisterService) { }
  ngOnInit() {
    this.getGenderList();
  }

  getGenderList() {
    this.registerService.getGender().subscribe(data => {
      this.genders = data;
      console.log(this.genders);
    });
  }
}
