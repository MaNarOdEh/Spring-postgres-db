import { Action } from "@ngrx/store";
import { Movie } from "src/app/shared/model/Movie";
export enum EMovieActions {
  GET_MOVIE = "[Movie] Get Movies",
  LOAD_MOVIE = "[Movie] Load Movies",
  ADD_MOVIE = "[Movie] Add Movie",
  REMOVE_MOVIE = "[REMOVE] Remove Movie",
}
export class LoadMovies implements Action {
  public readonly type = EMovieActions.LOAD_MOVIE;
  public constructor(public payload: Array<Movie>) {}
}

export class GetMovies implements Action {
  public readonly type = EMovieActions.GET_MOVIE;
}
export class AddMovies implements Action {
  public readonly type = EMovieActions.ADD_MOVIE;
  public constructor(public payload: Movie) {}
}
export class RemoveMovies implements Action {
  public readonly type = EMovieActions.REMOVE_MOVIE;
  public constructor(public payload: string) {}
}
export type MoieActions = GetMovies | AddMovies | RemoveMovies | LoadMovies;
