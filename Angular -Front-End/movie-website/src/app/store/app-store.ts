import * as fromLoginReducer from "./Reducer/login.reducer";
import { ActionReducerMap } from "@ngrx/store";
import * as fromMovieFavReducer from "../movie-fav/shared/store/fav-movie.reducer";
import { MovieEffects } from "../movie-fav/shared/store/fav-movie.effects";

export const reducers: ActionReducerMap<any> = {
  login: fromLoginReducer.reducer,
  favMovie: fromMovieFavReducer.reducer,
};

export const effects: Array<any> = [MovieEffects];
