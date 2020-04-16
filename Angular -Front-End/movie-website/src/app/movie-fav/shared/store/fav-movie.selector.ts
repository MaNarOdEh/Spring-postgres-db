import { createSelector, createFeatureSelector } from "@ngrx/store";
import { FavMovieState } from "./fav-movie.reducer";

const getFavMovieSelectorState = createFeatureSelector<FavMovieState>("movies");
export const getFavMovies = createSelector(
  getFavMovieSelectorState,
  (state: FavMovieState) => state.movies
);

export const getFavMoviesLoading = createSelector(
  getFavMovieSelectorState,
  (state: FavMovieState) => state.loading
);
export const getFavMoviesLoaded = createSelector(
  getFavMovieSelectorState,
  (state: FavMovieState) => state.loaded
);
export const getFavMoviesError = createSelector(
  getFavMovieSelectorState,
  (state: FavMovieState) => state.error
);
