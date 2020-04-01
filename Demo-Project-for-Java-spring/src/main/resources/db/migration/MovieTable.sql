CREATE TABLE movie(id UUID PRIMARY KEY NOT NULL,
                                       movieId VARCHAR(100) NOT NULL,
                                                            userId UUID NOT NULL,
                   FOREIGN KEY (userId) REFERENCES "user"(id));