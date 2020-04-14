import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Movie } from "../shared/model/Movie";
import { MovieDetailsServiceService } from "../shared/service/movie-details-service.service";

@Component({
  selector: "app-movie-details",
  templateUrl: "./movie-details.component.html",
  styleUrls: ["./movie-details.component.css"],
})
export class MovieDetailsComponent implements OnInit {
  id: string;
  movie: Movie = new Movie();

  constructor(
    private route: ActivatedRoute,
    private movieDetails: MovieDetailsServiceService
  ) {
    this.id = this.route.snapshot.paramMap.get("id");
  }

  ngOnInit(): void {
    this.movieDetails.getMovieDetails(this.id).subscribe((res) => {
      this.movie = res;
    });
  }
}
