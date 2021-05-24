create table posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                       created timestamp without time zone not null default now()
);

create table comment (
                         id SERIAL PRIMARY KEY,
                         description TEXT,
                         created TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
                         post_id INT NOT NULL REFERENCES posts(id)
);