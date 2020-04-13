import { TokenStorageService } from "./token-storage.service";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class UserService {
  private static login: boolean;
  constructor(private token: TokenStorageService) {}
  public getLogin() {
    UserService.login = this.token.getUser() == undefined ? false : true;
    return UserService.login;
  }
  public setLogin(login: boolean) {
    UserService.login = login;
  }
}
