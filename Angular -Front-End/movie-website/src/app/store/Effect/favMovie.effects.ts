import { MovieFavService } from "./../../movie-fav/shared/movie-fav.service";
import { AddMovieService } from "./../../movie-list/shared/add-movie.service";
import { MovieDetailsServiceService } from "../../shared/service/movie-details-service.service";
import { DeleteMovieService } from "../../shared/service/delete-movie.service";
import { Injectable } from "@angular/core";
/*
 * FavMovie (add[movieId,userName],delete[movieId,userName],get[username])
 * get ==> it will return all moviesid list of string
 *
 *
 */
@Injectable({ providedIn: "root" })
export class MovieEffects {
  constructor() {}
}
