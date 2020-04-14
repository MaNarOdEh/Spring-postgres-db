import { Action } from "@ngrx/store";
/*
 * this class will have 3 action
 * one for adding movie,deleting movie
 * get movie
 */
export enum MovieFavTypes {
  add = "ADD_FAV_MOVIE",
  remove = "REMOVE_FAV_MOVIE",
  LOAD_FAV_MOVIES = "[Movie Favourite API] LoadFavMovie",
  LOAD_FAV_MOVIES_FAIL = "[Movie Favourite API] LoadFavMovieFail",
  LOAD_FAV_MOVIES_SUCCESS = "[Movie Favourite API] LoadFavMovieSuccess",
}

export class LoadFavMovies implements Action {
  readonly type = MovieFavTypes.LOAD_FAV_MOVIES;
}
export class LoadFavMovieSuccess implements Action {
  readonly type = MovieFavTypes.LOAD_FAV_MOVIES_SUCCESS;
  public constructor(public payload: string[]) {}
}
export class LoadFavMovieFail implements Action {
  readonly type = MovieFavTypes.LOAD_FAV_MOVIES_FAIL;
  public constructor(public payload: string) {}
}
export type action = LoadFavMovies | LoadFavMovieSuccess | LoadFavMovieFail;
