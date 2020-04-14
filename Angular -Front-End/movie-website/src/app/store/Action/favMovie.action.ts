import { MovieFavTypes } from "./../enum/favMovieEnum";
import { Action } from "@ngrx/store";
/*
 * this class will have 3 action
 * one for adding movie,deleting movie
 * get movie
 */

export class LoadFavMovies implements Action {
  readonly type: MovieFavTypes.loadFavMovie;
  public constructor(public payload) {}
}
export class LoadFavMovieSuccess implements Action {
  readonly type: MovieFavTypes.LoadFavMovieSUCCESS;
  public constructor(public payload: string[]) {}
}
export class LoadFavMovieFail implements Action {
  readonly type: MovieFavTypes.loadFavMovieFail;
  public constructor(public payload: string) {}
}
export type action = LoadFavMovies | LoadFavMovieSuccess | LoadFavMovieFail;
