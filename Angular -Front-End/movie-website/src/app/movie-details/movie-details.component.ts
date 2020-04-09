import { MovieDetailsServiceService } from './shared/movie-details-service.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movie } from '../shared/model/Movie';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {
  id:string;
  movie:Movie;

  constructor(private route:ActivatedRoute,
    private movieDetails:MovieDetailsServiceService) { 
      this.id = this.route.snapshot.paramMap.get('id');
    }


  ngOnInit(): void {
    this.movieDetails.getMovieDetails(this.id).subscribe(res => {
      this.movie = res;
      console.log(res);
      console.log("Film Details : ", this.movie);
    });

  }

}
