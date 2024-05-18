CREATE TABLE owners
(
    id       UUID PRIMARY KEY,
    name     VARCHAR(255),
    birthday DATE,
    sex      VARCHAR(255)
);

CREATE TABLE cats
(
    id       UUID PRIMARY KEY,
    name     VARCHAR(255),
    birthday DATE,
    sex      VARCHAR(255),
    breed    VARCHAR(255),
    color    VARCHAR(255),
    owner_id UUID REFERENCES owners (id)
);

CREATE TABLE cat_friends
(
    cat_id    UUID REFERENCES cats (id),
    friend_id UUID REFERENCES cats (id),
    PRIMARY KEY (cat_id, friend_id)
);