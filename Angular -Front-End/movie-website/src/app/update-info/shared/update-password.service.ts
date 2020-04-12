import { TokenStorageService } from "src/app/shared/service/token-storage.service";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

const UPDATE_USER_API = "http://localhost:8080/api/v1/update/password";

@Injectable({
  providedIn: "root",
})
export class UpdatePasswordService {
  constructor(private http: HttpClient, private token: TokenStorageService) {}
  updateInfo(oldPassword: String, newPassowrd: String) {
    // this.http.put(`${UPDATE_USER_API}`);
  }
}
