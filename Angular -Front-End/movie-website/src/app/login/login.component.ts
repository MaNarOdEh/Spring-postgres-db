import { TokenStorageService } from "./../shared/service/token-storage.service";
import { AuthService } from "./../shared/service/auth.service";
import { Router } from "@angular/router";
import { Component, OnInit } from "@angular/core";

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
    private _tokenService: TokenStorageService
  ) {}

  ngOnInit(): void {}
  login(): void {
    let user = { username: this.username, password: this.password };
    this._authService.login(user).subscribe(
      (data) => {
        this._tokenService.saveToken(data.token);
        this._tokenService.saveUser(user);
        window.location.reload();
        this._router.navigate(["movies/mostPopular"]);
        this.error = "";
      },
      (err) => {
        console.log(err.message);
        this.error = "Wrong User Name or Password Please Try Again!";
      }
    );
  }
  signup(): void {
    let user = { username: this.username, password: this.password };
    console.log(user.password);
    console.log(user.username);
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
