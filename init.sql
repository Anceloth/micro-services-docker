CREATE TABLE author
(
    authorId bigint NOT NULL,
    authorName text COLLATE pg_catalog."default",
    CONSTRAINT author_pkey PRIMARY KEY (authorId)
);

INSERT INTO author(authorId, authorName) VALUES
 (1, 'Jonathan Marin Cermeno'),
 (2, 'Jhon Connor'),
 (3, 'Agent Smith');
 
 CREATE TABLE public.movie (
	movieid bigint NOT NULL,
	moviename varchar NULL,
	movieyear information_schema."time_stamp" NULL,
	authorid bigint NOT NULL,
	CONSTRAINT movie_pk PRIMARY KEY (movieid),
	CONSTRAINT movie_unique UNIQUE (authorid),
	CONSTRAINT movie_author_fk FOREIGN KEY (authorid) REFERENCES public.author(authorid)
);

INSERT INTO public.movie
(movieid, moviename, movieyear, authorid)
VALUES(1, 'Back to the Future', '2024-02-07 03:41:22.030', 1);
INSERT INTO public.movie
(movieid, moviename, movieyear, authorid)
VALUES(2, 'Terminator', '2024-02-07 03:42:57.420', 2);
INSERT INTO public.movie
(movieid, moviename, movieyear, authorid)
VALUES(3, 'Matrix', '2024-02-07 03:42:57.420', 3);

