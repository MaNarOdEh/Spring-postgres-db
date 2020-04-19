import { AddMovieService } from "./../../../movie-list/shared/add-movie.service";
import { Action } from "@ngrx/store";
import { Injectable } from "@angular/core";
import { Actions, Effect, ofType } from "@ngrx/effects";
import { Observable, of } from "rxjs";
import * as FavMoviesAction from "./fav-movie.action";
import { mergeMap, map, catchError } from "rxjs/operators";

@Injectable({ providedIn: "root" })
export class AddMovieFavEffects {
  constructor(
    private actions$: Actions,
    private movieFavService: AddMovieService
  ) {}
  @Effect()
  addFavMovie$: Observable<Action> = this.actions$.pipe(
    ofType<FavMoviesAction.AddFavMovie>(
      FavMoviesAction.EMovieFavTypes.ADD_FAV_MOVIE
    ),
    mergeMap((actions: FavMoviesAction.AddFavMovie) =>
      this.movieFavService.addMovie(actions.payload).pipe(
        map((movie) => new FavMoviesAction.AddFavMovieSuccess(actions.payload)),
        catchError((error) => of(new FavMoviesAction.AddFavMovieFail(error)))
      )
    )
  );
}
