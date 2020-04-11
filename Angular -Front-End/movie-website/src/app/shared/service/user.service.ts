import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class UserService {
  private login = false;
  constructor() {}
  public getLogin() {
    return this.login;
  }
  public setLogin(login: boolean) {
    this.login = login;
  }
}
