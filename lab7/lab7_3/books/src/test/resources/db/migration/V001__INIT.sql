CREATE TABLE books (
  nome VARCHAR(255) NOT NULL,
  age INT NOT NULL,
  nmec INT PRIMARY KEY NOT NULL,
  email VARCHAR(255) NOT NULL
);

INSERT INTO books (nome, age, nmec, email) VALUES ('Adriana', 17, 7653, 'adriana@ua.pt');
INSERT INTO books (nome, age, nmec, email) VALUES ('Rafael', 31, 9832, 'rafael@ua.pt');
INSERT INTO books (nome, age, nmec, email) VALUES ('Daniel', 31, 9832, 'daniel@ua.pt');