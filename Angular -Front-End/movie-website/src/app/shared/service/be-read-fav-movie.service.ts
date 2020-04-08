import { Injectable } from '@angular/core';
import 'rxjs/Rx';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BeReadFavMovieService {
  URLFAVORITEMOVIE = "http:localhost:8080/api/favMovie/"
  constructor(private http:HttpClient) { }
  getUserFavoriteMovie(userId:string, jwt:string){
    return this.http.get('$URLFAVORITEMOVIE/${userId}')

  }
}
