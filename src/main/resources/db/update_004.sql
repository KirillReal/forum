
create table comment_answers(
                                comment_id int references comment(id),
                                answers_id int references answers(id)
);