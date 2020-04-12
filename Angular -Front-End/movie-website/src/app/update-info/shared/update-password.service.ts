import { TokenStorageService } from "src/app/shared/service/token-storage.service";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import { throwError } from "rxjs";

const UPDATE_USER_API = "http://localhost:8080/api/user/update/password/";
const httpOptions = {
  headers: new HttpHeaders({ "content-Type": "application/json" }),
};
@Injectable({
  providedIn: "root",
})
export class UpdatePasswordService {
  constructor(private http: HttpClient, private token: TokenStorageService) {}
  updateInfo(oldPassword: String, newPassowrd: String) {
    let personInfo = this.token.getUser();
    if (personInfo.password != oldPassword) {
      return throwError("Old Password does Not much!!");
    } else {
      console.log("hey!");
      return this.http
        .put(
          `${UPDATE_USER_API}${oldPassword}`,
          {
            username: personInfo.username,
            password: newPassowrd,
          },
          httpOptions
        )
        .pipe(
          catchError((error) => {
            return throwError(error);
          })
        );
    }
  }
}
