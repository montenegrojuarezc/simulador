DROP TABLE IF EXISTS datos;

CREATE TABLE datos (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  descripcion VARCHAR(250) NOT NULL,
  tipo VARCHAR(250) NOT NULL
);