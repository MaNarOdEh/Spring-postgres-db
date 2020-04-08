import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  
  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  login() : void {
    if(this.username == 'admin' && this.password == 'admin'){
     //this.router.navigate(["user"]);
     alert("correct");
    }else {
      alert("Invalid credentials");
    }
  }
  signup():void{

  }

}
