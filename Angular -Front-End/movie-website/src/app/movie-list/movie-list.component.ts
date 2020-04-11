import { AddMovieService } from "./shared/add-movie.service";
import { Component, OnInit, Inject } from "@angular/core";
import { Observable } from "rxjs";
import { Router, ActivatedRoute } from "@angular/router";
import { ReadMovieService } from "./shared/read-movie.service";
import {
  MatDialogRef,
  MAT_DIALOG_DATA,
  MatDialog,
} from "@angular/material/dialog";
import { TokenStorageService } from "../shared/service/token-storage.service";

@Component({
  selector: "app-movie-list",
  templateUrl: "./movie-list.component.html",
  styleUrls: ["./movie-list.component.css"],
})
export class MovieListComponent implements OnInit {
  title: string;
  movieList: Observable<any>;
  movieType = "top_rated";

  constructor(
    private _router: Router,
    private _movieService: ReadMovieService,
    private _route: ActivatedRoute,
    private _token: TokenStorageService,
    private _addMovieService: AddMovieService,
    public dialog: MatDialog
  ) {
    this.title = this._route.snapshot.data["title"];
    this.movieType = this._route.snapshot.data["movieTypes"];
  }

  ngOnInit(): void {
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
      this._addMovieService.addMovie(movie.id).subscribe();
    }
  }
}
