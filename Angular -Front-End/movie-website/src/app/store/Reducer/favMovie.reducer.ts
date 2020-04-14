import { State } from "@ngrx/store";
import * as FavMoviesAction from "./../Action/favMovie.action";
import { MovieFavTypes } from "../enum/favMovieEnum";
/**
 * this class will createReducer that will deal with add,remove,get fav movies
 */
export interface MovieState {
  movie: String[];
  loading: boolean;
  loaded: boolean;
  error: string;
}
function favMovieReducer(
  state = movieFavInitialState,
  action: FavMoviesAction.action
): MovieState {
  switch (action.type) {
    case MovieFavTypes.loadFavMovie: {
      return {
        ...state,
        loading: true,
      };
    }
    case MovieFavTypes.LoadFavMovieSUCCESS: {
      return {
        ...state,
        loading: false,
        loaded: true,
        movie: action.payload,
      };
    }
    case MovieFavTypes.loadFavMovieFail: {
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
