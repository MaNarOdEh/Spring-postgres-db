import { TestBed } from '@angular/core/testing';

import { BeReadFavMovieService } from './be-read-fav-movie.service';

describe('BeReadFavMovieService', () => {
  let service: BeReadFavMovieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BeReadFavMovieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
