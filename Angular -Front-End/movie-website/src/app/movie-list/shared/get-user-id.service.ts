import { TokenStorageService } from './../../shared/service/token-storage.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const PERSON_API = "https://localhost:8080/api/user/";

@Injectable({
  providedIn: 'root'
})
export class GetUserIdService {

  constructor(private http:HttpClient,private token:TokenStorageService) { }
  getUserUUID(){
    let user = this.token.getUser();
    return this.http.get(`${PERSON_API}?api_key=${user.username}`)
  }
}
