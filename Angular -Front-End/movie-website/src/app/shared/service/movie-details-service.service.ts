import { MovieDB } from "./../../shared/model/MovieDB";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class MovieDetailsServiceService {
  moviedb: MovieDB;
  constructor(private http: HttpClient) {
    this.moviedb = MovieDB.getMovieDB();
  }
  getMovieDetails(movieId: String): Observable<any> {
    return this.http.get(
      `${this.moviedb.getBASEURL()}movie/${movieId}?api_key=${this.moviedb.getAPIKEY()}`
    );
  }
}
