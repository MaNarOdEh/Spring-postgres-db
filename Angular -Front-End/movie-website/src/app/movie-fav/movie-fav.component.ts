import { FavMovieState, FavMovieSt } from "./shared/store/fav-movie.reducer";
import { Observable } from "rxjs";
import { DeleteMovieService } from "./../shared/service/delete-movie.service";
import { MovieDetailsServiceService } from "./../shared/service/movie-details-service.service";
import { Component, OnInit } from "@angular/core";
import { Movie } from "../shared/model/Movie";
import { Router } from "@angular/router";
import { Store, select, State } from "@ngrx/store";
import { first } from "rxjs/operators";
import { LoginState } from "../store/Reducer/login.reducer";

import * as FavMoviesAction from "./shared/store/fav-movie.action";
import * as FavMovieSelector from "./shared/store/fav-movie.selector";

@Component({
  selector: "app-movie-fav",
  templateUrl: "./movie-fav.component.html",
  styleUrls: ["./movie-fav.component.css"],
})
export class MovieFavComponent implements OnInit {
  movieList: Movie[] = [];
  constructor(
    private _movieDetails: MovieDetailsServiceService,
    private _router: Router,
    private _store: Store<{ login: LoginState }>,
    private _movieStore: Store<FavMovieSt>
  ) {}

  ngOnInit(): void {
    this._store.pipe(first()).subscribe((data) => {
      if (data.login.isLogin == false) {
        this._router.navigate(["movies/mostPopular"]);
      }
    });

    this._movieStore.dispatch(new FavMoviesAction.LoadFavMovies());
    this._movieStore.subscribe((state) => {
      let movies = state["favMovie"].movies;
      this.movieList = [];
      for (let movie of movies) {
        this._movieDetails.getMovieDetails(movie).subscribe((res) => {
          this.movieList.push(res);
        });
      }
    });
  }
  naviagteToDetails(movie) {
    this._router.navigate(["/details", movie.id]);
  }
  removeMovie(movie: Movie) {
    this._movieStore.dispatch(
      new FavMoviesAction.RemoveFavMovie(movie.id.toString())
    );
    /* const index = this.movieList.indexOf(movie, 0);
    if (index > -1) {
      this.movieList.splice(index, 1);
    }
    this._movieRemove.removeMovie(movie.id).subscribe((res) => {});
    */
  }
}
