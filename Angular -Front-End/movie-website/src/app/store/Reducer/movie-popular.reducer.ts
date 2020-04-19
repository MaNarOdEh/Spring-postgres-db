import { Movie } from "./../../shared/model/Movie";
import {
  MoiePopularActions,
  EPopularMovieActions,
} from "./../Action/movie-popular.action";
import { MoviePopularState } from "../Model/MoviePopularState";

const initialState: Array<Movie> = [
  {
    adult: false,
    backdrop_path: "",
    genres: [],
    homepage: "",
    id: 0,
    imdb_id: "",
    original_language: "",
    original_title: "",
    overview: "",
    popularity: 0,
    poster_path: "",
    production_companies: [],
    production_countries: [],
    release_date: "",
    revenue: 0,
    runtime: 0,
    spoken_languages: [],
    status: "",
    tagline: "",
    title: "First Movie",
    video: false,
    vote_average: 0,
    vote_count: 0,
  },
];
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
  console.log("Type: ", action.type, "state: ", state);
  switch (action.type) {
    /*case EPopularMovieActions.GET_POPULAR_MOVIE: {
      console.log("Get Popular Movie!!!");
      /*return {
        ...state,
        loading: true,
        loaded: true,
        error: "",
      };
      return state;
    }*/
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
