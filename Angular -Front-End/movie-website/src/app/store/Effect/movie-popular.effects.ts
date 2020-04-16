import { Action } from "@ngrx/store";
import { Injectable } from "@angular/core";
import { Actions, createEffect, ofType, Effect } from "@ngrx/effects";
import { EMPTY, of, Observable } from "rxjs";
import { map, mergeMap, catchError } from "rxjs/operators";
import { ReadMovieService } from "src/app/movie-list/shared/read-movie.service";
import * as PopularMoviesAction from "./../Action/movie-popular.action";

/*
 * FavMovie (add[movieId,userName],delete[movieId,userName],get[username])
 * get ==> it will return all moviesid list of string
 *
 *
 */
//PopularMoviesAction
@Injectable({ providedIn: "root" })
export class MovieEffects {
  constructor(
    private actions$: Actions,
    private movieService: ReadMovieService
  ) {}
  @Effect()
  loadPopularMovies$: Observable<Action> = this.actions$.pipe(
    ofType<PopularMoviesAction.GetPopularMovies>(
      PopularMoviesAction.EPopularMovieActions.LOAD_POPULAR_MOVIE
    ),
    mergeMap((actions: PopularMoviesAction.GetPopularMovies) =>
      this.movieService.getMovies("popular").pipe(
        map(
          (movie) => new PopularMoviesAction.LoadPopularMoviesSuccuess(movie)
        ),
        catchError((error) =>
          of(new PopularMoviesAction.LoadPopularMoviesFail(error))
        )
      )
    )
  );
}
