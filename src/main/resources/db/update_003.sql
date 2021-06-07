create table answers(
                        id serial primary key,
                        content varchar(255),
                        created timestamp,
                        user_id int references users(id)
);

create table comment_answers(
                                 comment_id int references comment(id),
                                 answers_id int references answers(id)
);