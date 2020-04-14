import { TokenStorageService } from "./../../shared/service/token-storage.service";
import { Observable } from "rxjs";
import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from "@angular/common/http";

const ADD_MOVIE_API = "http://localhost:8080/api/favMovie/add/";
const httpOptions = {
  headers: new HttpHeaders({ "content-Type": "application/json" }),
};
@Injectable({
  providedIn: "root",
})
export class AddMovieService {
  constructor(private http: HttpClient, private token: TokenStorageService) {}
  addMovie(movieid): Observable<any> {
    let personInfo = this.token.getUser();
    return this.http.post(
      ADD_MOVIE_API,
      {
        movieid: movieid,
        person: {
          username: personInfo.username,
          password: personInfo.password,
        },
      },
      httpOptions
    );
  }
}
