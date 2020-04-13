import { UserService } from "./../shared/service/user.service";
import { UpdatePasswordService } from "./shared/update-password.service";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

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
    private _userService: UserService
  ) {}

  ngOnInit(): void {
    if (this._userService.getLogin() == false) {
      this._router.navigate(["/movies/topRating"]);
    }
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
