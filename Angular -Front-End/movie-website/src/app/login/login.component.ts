import { TokenStorageService } from "./../shared/service/token-storage.service";
import { AuthService } from "./../shared/service/auth.service";
import { Router } from "@angular/router";
import { Component, OnInit } from "@angular/core";
import { Store } from "@ngrx/store";
import { take } from "rxjs/operators";
import { login } from "../store/login.action";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;
  error: string;

  constructor(
    private _router: Router,
    private _authService: AuthService,
    private _tokenService: TokenStorageService,
    private _store: Store<{ login: boolean }>
  ) {}

  ngOnInit(): void {
    this._store.pipe(take(1)).subscribe((data) => {
      if (data.login == true) {
        this._router.navigate(["movies/mostPopular"]);
      }
    });
  }
  login(): void {
    let user = { username: this.username, password: this.password };
    if (user.username == undefined || user.password == undefined) {
      this.error = "All Field is Requierd!!";
    } else {
      this._authService.login(user).subscribe(
        (data) => {
          this._tokenService.saveToken(data.token);
          this._tokenService.saveUser(user);
          console.log(user, data.token);
          this._router.navigate(["movies/mostPopular"]);
          this._store.dispatch(
            login({ username: user.username, password: user.password })
          );
          this.error = "";
        },
        (err) => {
          console.log(err.message);
          this.error = "Wrong User Name or Password Please Try Again!";
        }
      );
    }
  }
  signup(): void {
    let user = { username: this.username, password: this.password };
    if (user.username == undefined || user.password == undefined) {
      this.error = "All Field is Requierd!!";
    } else {
      this._authService.register(user).subscribe(
        (data) => {
          console.log(data);
          this.error = "";
        },
        (err) => {
          console.log(err.message);
          this.error =
            "The userName is taken before \n please try with anouther user name";
        }
      );
    }
  }
}
