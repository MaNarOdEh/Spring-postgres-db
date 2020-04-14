import { DeleteMovieService } from "./../shared/service/delete-movie.service";
import { MovieDetailsServiceService } from "./../shared/service/movie-details-service.service";
import { MovieFavService } from "./shared/movie-fav.service";
import { Component, OnInit } from "@angular/core";
import { Movie } from "../shared/model/Movie";
import { Router } from "@angular/router";
import { Store } from "@ngrx/store";
import { TokenStorageService } from "../shared/service/token-storage.service";
import { take, first } from "rxjs/operators";
import { LoginState } from "../store/Reducer/login.reducer";

import * as FavMoviesAction from "./../store/Action/favMovie.action";

@Component({
  selector: "app-movie-fav",
  templateUrl: "./movie-fav.component.html",
  styleUrls: ["./movie-fav.component.css"],
})
export class MovieFavComponent implements OnInit {
  movieList: Movie[] = [];
  constructor(
    private _movieService: MovieFavService,
    private _movieDetails: MovieDetailsServiceService,
    private _movieRemove: DeleteMovieService,
    private _router: Router,
    private _store: Store<{ login: LoginState }>,
    private _movieStore: Store<any>
  ) {}

  ngOnInit(): void {
    this._store.pipe(first()).subscribe((data) => {
      if (data.login.isLogin == false) {
        this._router.navigate(["movies/mostPopular"]);
      }
    });
    this._movieStore.dispatch(new FavMoviesAction.LoadFavMovies());
    this._movieStore.subscribe((state) => {
      // console.log(state);
      console.log(state["favMovie"].movie);
    });
    /* this._movieService.getFavMovie().subscribe((res) => {
      let movies = res;
      for (let movie of movies) {
        this._movieDetails.getMovieDetails(movie).subscribe((res) => {
          this.movieList.push(res);
        });
      }
    });*/
  }
  naviagteToDetails(movie) {
    this._router.navigate(["/details", movie.id]);
  }
  removeMovie(movie: Movie) {
    const index = this.movieList.indexOf(movie, 0);
    if (index > -1) {
      this.movieList.splice(index, 1);
    }
    this._movieRemove.removeMovie(movie.id).subscribe((res) => {
      //  console.log(res);
    });
  }
}
