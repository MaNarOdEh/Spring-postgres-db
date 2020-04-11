import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieFavComponent } from './movie-fav.component';

describe('MovieFavComponent', () => {
  let component: MovieFavComponent;
  let fixture: ComponentFixture<MovieFavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieFavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieFavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
