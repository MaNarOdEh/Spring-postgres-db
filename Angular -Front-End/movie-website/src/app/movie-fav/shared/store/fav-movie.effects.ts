import { Action } from "@ngrx/store";
import { MovieFavService } from "../service/movie-fav.service";
import { Injectable } from "@angular/core";
import { Actions, ofType, Effect } from "@ngrx/effects";
import { of, Observable } from "rxjs";
import { map, mergeMap, catchError } from "rxjs/operators";
import * as FavMoviesAction from "./fav-movie.action";

/*
 * FavMovie (add[movieId,userName],delete[movieId,userName],get[username])
 * get ==> it will return all moviesid list of string
 *
 *
 */
@Injectable({ providedIn: "root" })
export class MovieFavEffects {
  constructor(
    private actions$: Actions,
    private movieFavService: MovieFavService
  ) {}
  /**
   * determine the type of action that will be listen which in our case loadFavMovie
   */
  @Effect()
  loadFavMovies$: Observable<Action> = this.actions$.pipe(
    ofType<FavMoviesAction.LoadFavMovies>(
      FavMoviesAction.MovieFavTypes.LOAD_FAV_MOVIES
    ),
    mergeMap((actions: FavMoviesAction.LoadFavMovies) =>
      this.movieFavService.getFavMovie().pipe(
        map((movie) => new FavMoviesAction.LoadFavMovieSuccess(movie)),
        catchError((error) => of(new FavMoviesAction.LoadFavMovieFail(error)))
      )
    )
  );
}
