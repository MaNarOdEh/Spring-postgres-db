import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { TokenStorageService } from "../shared/service/token-storage.service";
import { Store } from "@ngrx/store";
import { login, singout } from "../store/Action/login.action";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"],
})
export class HeaderComponent implements OnInit {
  name: string = "";
  login: boolean;

  constructor(
    private _router: Router,
    private token: TokenStorageService,
    private _store: Store<{ login: boolean }>
  ) {
    this.name = token.getUser() == null ? undefined : token.getUser().username;
    if (this.name != undefined) {
      this._store.dispatch(
        login({ username: this.name, password: token.getUser().password })
      );
    }
    this._store.subscribe((data) => {
      this.name =
        token.getUser() == null ? undefined : token.getUser().username;
      this.login = data.login;
    });
  }

  ngOnInit(): void {}
  naviagteToMostPopular() {
    this._router.navigate(["/movies/mostPopular"]);
  }
  naviagteToMostRating() {
    this._router.navigate(["/movies/topRating"]);
  }
  naviagteToFavoriteMovie() {
    this._router.navigate(["/movie/favourite"]);
  }
  showLogin() {
    this._router.navigate(["/login"]);
  }
  updateInfo() {
    this._router.navigate(["/user/updateInfo"]);
  }
  signOut(): void {
    this._store.dispatch(singout());
    this.token.signOut();
    this._router.navigate(["/movies/mostPopular"]);
  }
}
