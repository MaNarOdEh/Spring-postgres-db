import { State } from "@ngrx/store";
import * as FavMoviesAction from "./../Action/favMovie.action";
/**
 * this class will createReducer that will deal with add,remove,get fav movies
 */
export interface MovieState {
  movie: String[];
  loading: boolean;
  loaded: boolean;
  error: string;
}
export function reducer(
  state = movieFavInitialState,
  action: FavMoviesAction.action
): MovieState {
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
        movie: action.payload,
      };
    }
    case FavMoviesAction.MovieFavTypes.LOAD_FAV_MOVIES_FAIL: {
      return {
        ...state,
        movie: [],
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
export const movieFavInitialState: MovieState = {
  movie: [],
  loading: false,
  loaded: false,
  error: "",
};
