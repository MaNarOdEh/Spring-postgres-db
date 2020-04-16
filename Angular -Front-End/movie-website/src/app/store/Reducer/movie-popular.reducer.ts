import { Movie } from "./../../shared/model/Movie";
import {
  MoiePopularActions,
  EPopularMovieActions,
} from "./../Action/movie-popular.action";
import { MoviePopularState } from "../Model/MoviePopularState";

const initialState: Array<Movie> = [];
/*const initialState: MoviePopularState = {
  movies: [],
  loading: false,
  loaded: false,
  error: "",
};
*/
export function moviePopularReducer(
  state: Array<Movie> = initialState,
  action: MoiePopularActions
) {
  switch (action.type) {
    case EPopularMovieActions.GET_POPULAR_MOVIE: {
      console.log("here!!");
      /*return {
        ...state,
        loading: true,
        loaded: true,
        error: "",
      };*/
      return state;
    }
    case EPopularMovieActions.LOAD_POPULAR_MOVIE_FAIL: {
      /* return {
        ...state,
        loading: false,
        loaded: false,
        error: action.payload,
      };*/
      return state;
    }
    case EPopularMovieActions.LOAD_POPULAR_MOVIE_SUCCUESS: {
      /*return {
        ...state,
        movies: action.payload,
        loading: false,
        loaded: false,
        error: "",
      };*/
      return (state = action.payload);
    }
    default: {
      return state;
    }
  }
}
