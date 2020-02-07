CREATE TABLE TB_USUARIO (
  id integer NOT NULL AUTO_INCREMENT,
  username varchar(200) NOT NULL,
  password varchar(50) NOT NULL,
  data_criacao timestamp NOT NULL,
  data_modificacao timestamp DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;