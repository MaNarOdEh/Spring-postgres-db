import { MovieDetailsServiceService } from "./../shared/service/movie-details-service.service";
import { Observable } from "rxjs";
import { MovieFavService } from "./shared/movie-fav.service";
import { Component, OnInit } from "@angular/core";
import { Movie } from "../shared/model/Movie";
import { Router } from "@angular/router";

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
    private _router: Router
  ) {}

  ngOnInit(): void {
    this._movieService.getFavMovie().subscribe((res) => {
      let movies = res;
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
  removeMovie(movie) {}
}
