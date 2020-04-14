import * as fromLoginReducer from "./Reducer/login.reducer";
import { ActionReducerMap } from "@ngrx/store";
import * as fromMovieFavReducer from "./Reducer/favMovie.reducer";
import { MovieEffects } from "./Effect/favMovie.effects";

export const reducers: ActionReducerMap<any> = {
  login: fromLoginReducer.reducer,
  favMovie: fromMovieFavReducer.reducer,
};

//export const effects: Array<any>[] =  [MovieEffects];
