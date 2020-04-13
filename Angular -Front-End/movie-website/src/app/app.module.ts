import { AuthService } from "./shared/service/auth.service";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./header/header.component";
import { FooterComponent } from "./footer/footer.component";
import { LoginComponent } from "./login/login.component";
import { MovieListComponent } from "./movie-list/movie-list.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MatIconModule } from "@angular/material/icon";
import { MatToolbarModule } from "@angular/material/toolbar";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { MatCardModule } from "@angular/material/card";
import { MatGridListModule } from "@angular/material/grid-list";
import { MatMenuModule } from "@angular/material/menu";
import { MatButtonModule } from "@angular/material/button";
import { MatDialogModule } from "@angular/material/dialog";

import { FormsModule } from "@angular/forms";
import { MovieDetailsComponent } from "./movie-details/movie-details.component";
import { AuthInterceptor } from "./shared/service/_helpers/auth-interceptor";
import { MovieFavComponent } from "./movie-fav/movie-fav.component";
import { UpdateInfoComponent } from "./update-info/update-info.component";
import { StoreModule } from "@ngrx/store";
import { reducerFunction } from "./store/store";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    MovieListComponent,
    MovieDetailsComponent,
    MovieFavComponent,
    UpdateInfoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatToolbarModule,
    MatCardModule,
    MatGridListModule,
    HttpClientModule,
    FormsModule,
    MatMenuModule,
    MatDialogModule,
    MatButtonModule,
    StoreModule.forRoot({ firstReducer: reducerFunction }),
  ],
  providers: [
    AuthService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
