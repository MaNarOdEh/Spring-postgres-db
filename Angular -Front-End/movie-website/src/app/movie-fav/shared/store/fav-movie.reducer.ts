import { State } from "@ngrx/store";
import * as FavMoviesAction from "./fav-movie.action";
/**
 * this class will createReducer that will deal with add,remove,get fav movies
 */
export interface FavMovieState {
  movies: String[];
  loading: boolean;
  loaded: boolean;
  error: string;
}
export function reducer(
  state = movieFavInitialState,
  action: FavMoviesAction.action
): FavMovieState {
  switch (action.type) {
    case FavMoviesAction.MovieFavTypes.LOAD_FAV_MOVIES: {
      return {
        ...state,
        loading: true,
      };
    }
    case FavMoviesAction.MovieFavTypes.LOAD_FAV_MOVIES_SUCCESS: {
      return {
        ...state,
        loading: false,
        loaded: true,
        movies: action.payload,
      };
    }
    case FavMoviesAction.MovieFavTypes.LOAD_FAV_MOVIES_FAIL: {
      return {
        ...state,
        movies: [],
        loading: false,
        loaded: false,
        error: action.payload,
      };
    }

    default: {
      return movieFavInitialState;
    }
  }
}
export const movieFavInitialState: FavMovieState = {
  movies: [],
  loading: false,
  loaded: false,
  error: "",
};
export interface FavMovieSt {
  movies: FavMovieState;
}
