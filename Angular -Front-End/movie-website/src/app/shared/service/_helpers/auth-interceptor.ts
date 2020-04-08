import { TokenStorageService } from '../token-storage.service';
import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HTTP_INTERCEPTORS, HttpInterceptor } from '@angular/common/http';

const TOKEN_HEADER_KEY = "Authorization";

/*
  this class will help us to inspect and transform HTTP request
  'we want to add Authorization header with Bearer prefix to the token' 
*/
@Injectable()
export class AuthInterceptor implements HttpInterceptor{
  
  constructor(private token:TokenStorageService) { }
  intercept(request:HttpRequest<any>, next:HttpHandler){
    const token = this.token.getToken();
    let authReq = request;
    if(token != null){
      authReq = request.clone(
        {headers:request.headers.set(TOKEN_HEADER_KEY,'Bearer '+token)});
    }
    return next.handle(authReq);
  }
}
export const authInterceptorProviders = [
  {provide:HTTP_INTERCEPTORS,useClass:AuthInterceptor,multi:true}
];
