import { Action } from "@ngrx/store";
import { DeleteMovieService } from "./../../../shared/service/delete-movie.service";
import { Injectable } from "@angular/core";
import { Actions, Effect, ofType } from "@ngrx/effects";
import { Observable, of } from "rxjs";
import * as FavMoviesAction from "./fav-movie.action";
import { mergeMap, map, catchError } from "rxjs/operators";

@Injectable({ providedIn: "root" })
export class DeleteMovieFavEffects {
  constructor(
    private actions$: Actions,
    private movieFavService: DeleteMovieService
  ) {}
  @Effect()
  deleteFavMovie$: Observable<Action> = this.actions$.pipe(
    ofType<FavMoviesAction.RemoveFavMovie>(
      FavMoviesAction.EMovieFavTypes.REMOVE_FAV_MOVIES
    ),
    mergeMap((actions: FavMoviesAction.RemoveFavMovie) =>
      this.movieFavService.removeMovie(actions.payload).pipe(
        map(
          (movie) => new FavMoviesAction.RemoveFavMovieSuccess(actions.payload)
        ),
        catchError((error) => of(new FavMoviesAction.RemoveFavMovieFail(error)))
      )
    )
  );
}
