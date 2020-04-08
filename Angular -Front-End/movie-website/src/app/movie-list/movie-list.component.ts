import { ReadMovieService } from './../shared/service/read-movie.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  title:string;
  movieList:Observable<any>;
  movieType="top_rated";
  //popular

  constructor(private myrouter:Router,private movieService:ReadMovieService) { 
    this.title = "Most Rated Movie";
  }

  ngOnInit(): void {
    this.movieService.getMovies(this.movieType).subscribe(
      res=>{
          this.movieList = res.results;
      });

  }
  naviagteToDetails(movie){
    this.myrouter.navigate(['/details',movie.id]);
  }


}
