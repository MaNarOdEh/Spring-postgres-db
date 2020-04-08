import { TestBed } from '@angular/core/testing';

import { ReadMovieService } from './read-movie.service';

describe('ReadMovieService', () => {
  let service: ReadMovieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadMovieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
