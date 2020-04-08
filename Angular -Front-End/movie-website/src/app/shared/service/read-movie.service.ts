import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MovieDB } from '../model/MovieDB';

@Injectable({
  providedIn: 'root'
})
export class ReadMovieService {
  movieDB:MovieDB;
  constructor(private http:HttpClient) { 
    this.movieDB =  MovieDB.getMovieDB();
  }
  public getMovies(movieType:string):Observable<any>{
    return this.http.get(`${this.movieDB.getBASEURL()}movie/${movieType}?api_key=${this.movieDB.getAPIKEY()}`)
  }
}
