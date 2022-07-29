INSERT INTO author (id, first_name, last_name)
VALUES (1, 'Bladimir', 'Minga');

INSERT INTO author (id, first_name, last_name)
VALUES (2, 'Matías', 'Minga');

INSERT INTO author (id, first_name, last_name)
VALUES (3, 'Paula', 'Brito');

INSERT INTO book (id, pages, title, author_id)
VALUES (1, 100, 'El principito', 1);

INSERT INTO book (id, pages, title, author_id)
VALUES (2, 150, 'Las aventuras de Alicia en el país de las maravillas', 1);

INSERT INTO book (id, pages, title, author_id)
VALUES (3, 199, 'Don Quijote de la Mancha', 2);

INSERT INTO book (id, pages, title, author_id)
VALUES (4, 201, 'El Señor de los Anillos', 3);

UPDATE GEN
SET NEXT_VAL = 52
WHERE SEQUENCE_NAME = 'author';

UPDATE GEN
SET NEXT_VAL = 53
WHERE SEQUENCE_NAME = 'book';