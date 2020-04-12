import { UpdatePasswordService } from "./shared/update-password.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-update-info",
  templateUrl: "./update-info.component.html",
  styleUrls: ["./update-info.component.css"],
})
export class UpdateInfoComponent implements OnInit {
  oldPassword: string;
  password: string;
  error: string;
  constructor(private _updatePasswordService: UpdatePasswordService) {}

  ngOnInit(): void {}
  update() {
    this.error = "";
    console.log(this.oldPassword);
    console.log(this.password);
    if (this.oldPassword == undefined || this.password == undefined) {
      this.error = "All field is requierd";
    } else {
      this._updatePasswordService
        .updateInfo(this.oldPassword, this.password)
        .subscribe((arg) => console.log(arg));
    }
  }
}
