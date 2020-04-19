import { GetPopularMovies } from "./../store/Action/movie-popular.action";
import { AddMovieService } from "./shared/add-movie.service";
import { Component, OnInit, Inject } from "@angular/core";
import { Observable } from "rxjs";
import { Router, ActivatedRoute } from "@angular/router";
import { ReadMovieService } from "./shared/read-movie.service";
import { MatDialog } from "@angular/material/dialog";
import { TokenStorageService } from "../shared/service/token-storage.service";
import { AppState } from "../store/Model/app-state.model";
import { Store } from "@ngrx/store";
import { Movie } from "../shared/model/Movie";
import { FavMovieSt } from "../movie-fav/shared/store/fav-movie.reducer";
import * as FavMoviesAction from "../movie-fav/shared/store/fav-movie.action";

@Component({
  selector: "app-movie-list",
  templateUrl: "./movie-list.component.html",
  styleUrls: ["./movie-list.component.css"],
})
export class MovieListComponent implements OnInit {
  title: string;

  movieType = "top_rated";
  movies: Observable<Movie[]>;
  movieList: any;
  constructor(
    private _router: Router,
    private _movieService: ReadMovieService,
    private _route: ActivatedRoute,
    private _token: TokenStorageService,
    private _addMovieService: AddMovieService,
    public dialog: MatDialog,
    public store: Store<AppState>,
    private _movieStore: Store<FavMovieSt>
  ) {
    this.title = this._route.snapshot.data["title"];
    this.movieType = this._route.snapshot.data["movieTypes"];
    console.log("before dispatch loading movies");
    this.store.dispatch(new GetPopularMovies(this.movieType));
  }

  ngOnInit(): void {
    // this.store.dispatch(new GetPopularMovies(this.movieType));

    //this.movies = this.store.select("movieslist");
    /*this.store.select("movieslist").subscribe((res) => {
      //  console.log("Empty Arrays:  ", res);
    });*/
    //  this.movies = this.store.select("movieslist");
    //  console.log(this.movies);
    this._movieService.getMovies(this.movieType).subscribe((res) => {
      this.movieList = res.results;
    });
  }
  naviagteToDetails(movie) {
    this._router.navigate(["/details", movie.id]);
  }
  addMovie(movie) {
    if (this._token.getUser() == null) {
      window.alert("you should log in first!");
    } else {
      this._movieStore.dispatch(
        new FavMoviesAction.AddFavMovie(movie.id.toString())
      );
    }
  }
}
