import { Movie } from "src/app/shared/model/Movie";

export interface MoviePopularState {
  movies: Array<Movie>;
  loading: boolean;
  loaded: boolean;
  error: string;
}
