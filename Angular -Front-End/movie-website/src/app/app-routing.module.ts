import { MovieFavComponent } from "./movie-fav/movie-fav.component";
import { MovieDetailsComponent } from "./movie-details/movie-details.component";
import { MovieListComponent } from "./movie-list/movie-list.component";
import { LoginComponent } from "./login/login.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

const routes: Routes = [
  { path: "login", component: LoginComponent },
  {
    path: "movies/mostPopular",
    component: MovieListComponent,
    data: {
      movieTypes: "popular",
      title: "Most Popular Movie",
    },
  },
  {
    path: "movies/topRating",
    component: MovieListComponent,
    data: {
      movieTypes: "top_rated",
      title: "Most Rated Movie",
    },
  },
  { path: "details/:id", component: MovieDetailsComponent },
  { path: "movie/favourite", component: MovieFavComponent },
  { path: "**", redirectTo: "movies/topRating" },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
