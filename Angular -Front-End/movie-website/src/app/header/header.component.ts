import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { TokenStorageService } from "../shared/service/token-storage.service";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"],
})
export class HeaderComponent implements OnInit {
  name: string;
  login = true;

  constructor(private _router: Router, private token: TokenStorageService) {
    this.name = token.getUser() == null ? undefined : token.getUser().username;
    if (this.name == undefined) {
      this.login = false;
    }
  }

  ngOnInit(): void {}
  naviagteToMostPopular() {
    this._router.navigate(["/movies/mostPopular"]);
  }
  naviagteToMostRating() {
    this._router.navigate(["/movies/topRating"]);
  }
  showLogin() {
    this._router.navigate(["/login"]);
  }
  signOut(): void {
    this.name = "";
    this.token.signOut();
    this.login = false;
  }
}
