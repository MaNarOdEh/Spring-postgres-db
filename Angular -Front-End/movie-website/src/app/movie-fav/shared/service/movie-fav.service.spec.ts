import { TestBed } from "@angular/core/testing";

import { MovieFavService } from "./movie-fav.service";

describe("MovieFavService", () => {
  let service: MovieFavService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovieFavService);
  });

  it("should be created", () => {
    expect(service).toBeTruthy();
  });
});
