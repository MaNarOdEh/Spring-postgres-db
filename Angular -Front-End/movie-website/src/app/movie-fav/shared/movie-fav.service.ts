import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { TokenStorageService } from "src/app/shared/service/token-storage.service";
import { Observable } from "rxjs";
const FAV_MOVIE_API = "http://localhost:8080/api/favMovie/add/";
const httpOptions = {
  headers: new HttpHeaders({ "content-Type": "application/json" }),
};
@Injectable({
  providedIn: "root",
})
export class MovieFavService {
  constructor(private http: HttpClient, private token: TokenStorageService) {}
  getFavMovie(): Observable<any> {
    let personInfo = this.token.getUser();
    return this.http.get(`FAV_MOVIE_API?username=${personInfo.username}`);
  }
}
