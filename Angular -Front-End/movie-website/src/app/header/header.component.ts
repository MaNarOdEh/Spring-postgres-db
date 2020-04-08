import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private _router:Router) { }

  ngOnInit(): void {
  }
  naviagteToMostPopular(){
    this._router.navigate(['/mostPopularity']);
  }
  naviagteToMostRating(){
    this._router.navigate(['/topRated']);
  }
  showLogin(){
    this._router.navigate(['/login']);
  }

}
