import { Movie } from "./../../shared/model/Movie";
import { Action } from "@ngrx/store";
export enum EPopularMovieActions {
  GET_POPULAR_MOVIE = "[Movie] Get Popular Movies",
  LOAD_POPULAR_MOVIE = "[Movie] Load Popular Movies",
  LOAD_POPULAR_MOVIE_FAIL = "[Movie] Load Popular Movies Fail",
  LOAD_POPULAR_MOVIE_SUCCUESS = "[Movie] Load Popular Movies Succuess",
}
/*export class LoadPopularMovies implements Action {
  public readonly type = EPopularMovieActions.LOAD_POPULAR_MOVIE;
    | LoadPopularMovies
}*/
export class GetPopularMovies implements Action {
  public readonly type = EPopularMovieActions.GET_POPULAR_MOVIE;
  public constructor(public payload: string) {}
}

export class LoadPopularMoviesFail implements Action {
  public readonly type = EPopularMovieActions.LOAD_POPULAR_MOVIE_FAIL;
  public constructor(public payload: string) {}
}

export class LoadPopularMoviesSuccuess implements Action {
  public readonly type = EPopularMovieActions.LOAD_POPULAR_MOVIE_SUCCUESS;
  public constructor(public payload: Array<Movie>) {}
}
export type MoiePopularActions =
  | GetPopularMovies
  | LoadPopularMoviesFail
  | LoadPopularMoviesSuccuess;
