import { Observable } from "rxjs";
import { MovieFavService } from "./shared/movie-fav.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-movie-fav",
  templateUrl: "./movie-fav.component.html",
  styleUrls: ["./movie-fav.component.css"],
})
export class MovieFavComponent implements OnInit {
  movieList: Observable<any>;
  constructor(private _movieService: MovieFavService) {}

  ngOnInit(): void {
    this._movieService.getFavMovie().subscribe((res) => {
      this.movieList = res;
    });
  }
}
