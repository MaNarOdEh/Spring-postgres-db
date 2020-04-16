import { createSelector } from "@ngrx/store";
import { Movie } from "src/app/shared/model/Movie";

export interface AppState {
  readonly movieslist: Array<Movie>;
}

/*
const selectFeatureCounter = (state: AppState) => state.count;
const selectFeatureShoppin = (state: AppState) => state.shopping;

export const selectFeatureCounerName = () =>
  createSelector(selectFeatureCounter, (state: Counter) => state.name_);

export const selectFeatureCounterCount = () =>
  createSelector(selectFeatureCounter, (state: Counter) => state.counter_);
*/
