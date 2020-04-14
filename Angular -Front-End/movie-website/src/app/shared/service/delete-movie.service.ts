import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { TokenStorageService } from "./token-storage.service";
import { catchError } from "rxjs/operators";
import { throwError } from "rxjs";

const FAV_MOVIE_API = "http://localhost:8080/api/favMovie/";

@Injectable({
  providedIn: "root",
})
export class DeleteMovieService {
  constructor(private http: HttpClient, private token: TokenStorageService) {}
  removeMovie(movieId) {
    let personInfo = this.token.getUser();
    return this.http
      .delete(`${FAV_MOVIE_API}${personInfo.username}/${movieId}`)
      .pipe(
        catchError((error) => {
          return throwError(error);
        })
      );
  }
}
