import { MovieFavEffects } from "./../movie-fav/shared/store/fav-movie.effects";
import { MovieEffects } from "./Effect/movie-popular.effects";
import * as fromLoginReducer from "./Reducer/login.reducer";
import { ActionReducerMap } from "@ngrx/store";
import * as fromMovieFavReducer from "../movie-fav/shared/store/fav-movie.reducer";
import { moviePopularReducer } from "./Reducer/movie-popular.reducer";

export const reducers: ActionReducerMap<any> = {
  login: fromLoginReducer.reducer,
  favMovie: fromMovieFavReducer.reducer,
  movieslist: moviePopularReducer,
};

export const effects: Array<any> = [MovieEffects, MovieFavEffects];
