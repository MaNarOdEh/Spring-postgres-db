import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';
import { ReadMovieService } from './shared/read-movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  title:string;
  movieList:Observable<any>;
  movieType="top_rated";

  constructor(private _router:Router,private _movieService:ReadMovieService
    ,private _route:ActivatedRoute) { 
    this.title = this._route.snapshot.data['title'];
    this.movieType = this._route.snapshot.data['movieTypes'];
  }

  ngOnInit(): void {
    this._movieService.getMovies(this.movieType).subscribe(
      res=>{
          this.movieList = res.results;
      });

  }
  naviagteToDetails(movie){
    this._router.navigate(['/details',movie.id]);
  }
  addMovie(movie){
    console.log(movie.id);
  }


}
