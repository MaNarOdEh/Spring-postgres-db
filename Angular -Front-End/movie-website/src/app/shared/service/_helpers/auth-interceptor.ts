import { Router } from "@angular/router";
import { TokenStorageService } from "../token-storage.service";
import { Injectable } from "@angular/core";
import {
  HttpRequest,
  HttpHandler,
  HTTP_INTERCEPTORS,
  HttpInterceptor,
  HttpEvent,
} from "@angular/common/http";
import { throwError, Observable } from "rxjs";
import { catchError } from "rxjs/operators";
const TOKEN_HEADER_KEY = "Authorization";

/*
  this class will help us to inspect and transform HTTP request
  'we want to add Authorization header with Bearer prefix to the token' 
*/
@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private token: TokenStorageService, private _router: Router) {}
  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const token = this.token.getToken();
    let authReq = request;
    if (token != null) {
      authReq = request.clone({
        headers: request.headers.set(TOKEN_HEADER_KEY, "Bearer " + token),
      });
    }
    return next.handle(authReq).pipe(
      catchError((error) => {
        //if the error is an authentication Error
        if (error.status === 401) {
          this._router.navigate(["/login"]);
        }
        return throwError(error);
      })
    );
  }
}
export const authInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
];
