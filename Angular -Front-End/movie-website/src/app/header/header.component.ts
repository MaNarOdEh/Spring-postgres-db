import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { TokenStorageService } from "../shared/service/token-storage.service";
import { Store, select } from "@ngrx/store";
import { Observable } from "rxjs";
import { singout, login } from "../store/login.action";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"],
})
export class HeaderComponent implements OnInit {
  name: string;
  login: boolean;

  constructor(
    private _router: Router,
    private token: TokenStorageService,
    private _store: Store<{ login: boolean }>
  ) {
    this.name = token.getUser() == null ? undefined : token.getUser().username;
    if (this.name != undefined) {
      this._store.dispatch(login());
    }
    // this.login = _store.pipe(select("login"));
    this._store.subscribe((data) => {
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
