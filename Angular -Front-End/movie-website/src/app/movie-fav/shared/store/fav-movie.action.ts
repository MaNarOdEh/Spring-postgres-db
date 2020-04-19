import { Action } from "@ngrx/store";
/*
 * this class will have 3 action
 * one for adding movie,deleting movie
 * get movie
 */
export enum EMovieFavTypes {
  LOAD_FAV_MOVIES = "[Movie Favourite API] LoadFavMovie",
  LOAD_FAV_MOVIES_FAIL = "[Movie Favourite API] LoadFavMovieFail",
  LOAD_FAV_MOVIES_SUCCESS = "[Movie Favourite API] LoadFavMovieSuccess",
  REMOVE_FAV_MOVIES = "[Movie Favourite API] RemoveFavMovie",
  REMOVE_FAV_MOVIE_FAIL = "[Movie Favourite API] RemoveFavMovieFail",
  REMOVE_FAV_MOVIE_SUCCESS = "[Movie Favourite API] RemoveFavMovieSuccess",
  ADD_FAV_MOVIE = "[Movie Favourite API] AddFavMovie",
  ADD_FAV_MOVIE_FAIL = "[Movie Favourite API] AddFavMovieFail",
  ADD_FAV_MOVIE_SUCCESS = "[Movie Favourite API] AddFavMovieSuccess",
}

export class LoadFavMovies implements Action {
  readonly type = EMovieFavTypes.LOAD_FAV_MOVIES;
}
export class LoadFavMovieSuccess implements Action {
  readonly type = EMovieFavTypes.LOAD_FAV_MOVIES_SUCCESS;
  public constructor(public payload: string[]) {}
}
export class LoadFavMovieFail implements Action {
  readonly type = EMovieFavTypes.LOAD_FAV_MOVIES_FAIL;
  public constructor(public payload: string) {}
}
export class RemoveFavMovie implements Action {
  readonly type = EMovieFavTypes.REMOVE_FAV_MOVIES;
  public constructor(public payload: string) {}
}
export class RemoveFavMovieFail implements Action {
  readonly type = EMovieFavTypes.REMOVE_FAV_MOVIE_FAIL;
  public constructor(public payload: string) {}
}
export class RemoveFavMovieSuccess implements Action {
  readonly type = EMovieFavTypes.REMOVE_FAV_MOVIE_SUCCESS;
  public constructor(public payload: string) {}
}
export class AddFavMovie implements Action {
  readonly type = EMovieFavTypes.ADD_FAV_MOVIE;
  public constructor(public payload: string) {}
}
export class AddFavMovieFail implements Action {
  readonly type = EMovieFavTypes.ADD_FAV_MOVIE_FAIL;
  public constructor(public payload: string) {}
}
export class AddFavMovieSuccess implements Action {
  readonly type = EMovieFavTypes.ADD_FAV_MOVIE_SUCCESS;
  public constructor(public payload: string) {}
}
export type action =
  | LoadFavMovies
  | LoadFavMovieSuccess
  | LoadFavMovieFail
  | RemoveFavMovie
  | RemoveFavMovieFail
  | RemoveFavMovieSuccess
  | AddFavMovie
  | AddFavMovieFail
  | AddFavMovieSuccess;
