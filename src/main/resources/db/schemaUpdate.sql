CREATE TABLE authorities (
                             id SERIAL PRIMARY KEY,
                             authority VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       enabled BOOLEAN DEFAULT TRUE,
                       authority_id INT NOT NULL REFERENCES authorities(id)
);

INSERT INTO authorities (authority) VALUES ('ROLE_USER');

ALTER TABLE posts
    ADD COLUMN user_id INT NOT NULL REFERENCES users(id);
ALTER TABLE comment
    ADD COLUMN user_id INT NOT NULL REFERENCES users(id);