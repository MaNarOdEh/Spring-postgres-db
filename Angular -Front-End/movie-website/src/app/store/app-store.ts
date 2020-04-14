import * as fromLoginReducer from "./Reducer/login.reducer";
import { ActionReducerMap } from "@ngrx/store";

export const reducers: ActionReducerMap<any> = {
  login: fromLoginReducer.reducer,
};
