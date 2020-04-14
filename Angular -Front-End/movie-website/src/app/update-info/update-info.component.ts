import { TokenStorageService } from "src/app/shared/service/token-storage.service";
import { UpdatePasswordService } from "./shared/update-password.service";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Store } from "@ngrx/store";
import { LoginState } from "../store/Reducer/login.reducer";
import { first } from "rxjs/operators";

@Component({
  selector: "app-update-info",
  templateUrl: "./update-info.component.html",
  styleUrls: ["./update-info.component.css"],
})
export class UpdateInfoComponent implements OnInit {
  oldPassword: string;
  password: string;
  error: string;
  constructor(
    private _router: Router,
    private _updatePasswordService: UpdatePasswordService,
    private _store: Store<{ login: LoginState }>
  ) {}

  ngOnInit(): void {
    this._store.pipe(first()).subscribe((data) => {
      if (data.login.isLogin == false) {
        this._router.navigate(["movies/mostPopular"]);
      }
    });
  }
  update() {
    this.error = "";
    if (this.oldPassword == undefined || this.password == undefined) {
      this.error = "All field is requierd";
    } else {
      this._updatePasswordService
        .updateInfo(this.oldPassword, this.password)
        .subscribe(
          (arg) => {},
          (err) => {
            // this.error = err;
          }
        );
    }
  }
}
