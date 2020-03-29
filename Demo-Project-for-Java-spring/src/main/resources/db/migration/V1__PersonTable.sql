CREATE TABLE person (id UUID PRIMARY KEY NOT NULL,
                                         userName VARCHAR(100) NOT NULL UNIQUE,
                                                                        userPassword VARCHAR(100) NOT NULL);

