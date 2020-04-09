import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { GetUserIdService } from './get-user-id.service';

const ADD_MOVIE_API = "https://localhost:8080/api/favMovie/add";
const httpOptions= {
  headers: new HttpHeaders({'content-Type':'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class AddMovieService {

  constructor(private http:HttpClient,private getUserId:GetUserIdService) {}
   addMovie(movieid):Observable<any>{
     let personid = this.getUserId.getUserUUID();
    return this.http.post(ADD_MOVIE_API,{
      movieid:movieid,
      person:{
        id:personid
      }
    },httpOptions);
  }
}
