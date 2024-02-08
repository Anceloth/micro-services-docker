CREATE TABLE author
(
    author_id bigint NOT NULL,
    author_name text COLLATE pg_catalog."default",
    CONSTRAINT author_pkey PRIMARY KEY (author_id)
);

INSERT INTO author(author_id, author_name) VALUES
 (1, 'Jonathan Marin Cermeno'),
 (2, 'Jhon Connor'),
 (3, 'Agent Smith');
 
 CREATE TABLE public.movie (
	movie_id bigint NOT NULL,
	movie_name varchar NULL,
	movie_year information_schema."time_stamp" NULL,
	author_id bigint NOT NULL,
	CONSTRAINT movie_pk PRIMARY KEY (movie_id),
	CONSTRAINT movie_unique UNIQUE (author_id),
	CONSTRAINT movie_author_fk FOREIGN KEY (author_id) REFERENCES public.author(author_id)
);

INSERT INTO public.movie
(movie_id, movie_name, movie_year, author_id)
VALUES(1, 'Back to the Future', '2024-02-07 03:41:22.030', 1);
INSERT INTO public.movie
(movie_id, movie_name, movie_year, author_id)
VALUES(2, 'Terminator', '2024-02-07 03:42:57.420', 2);
INSERT INTO public.movie
(movie_id, movie_name, movie_year, author_id)
VALUES(3, 'Matrix', '2024-02-07 03:42:57.420', 3);

