CREATE TABLE TB_CERVEJA (
  id integer NOT NULL AUTO_INCREMENT,
  marca varchar(200) NOT NULL,
  teor_alcoolico double DEFAULT NULL,
  tipo varchar(50) DEFAULT NULL,
  preco decimal(19,2) DEFAULT NULL,
  data_lancamento timestamp DEFAULT NULL,
  data_criacao timestamp DEFAULT NULL,
  data_modificacao timestamp DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;