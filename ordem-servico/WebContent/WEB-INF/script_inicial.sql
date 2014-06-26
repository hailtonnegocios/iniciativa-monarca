CREATE DATABASE  IF NOT EXISTS `ordem_servico`;
USE `ordem_servico`;

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `FROM_CLASS` varchar(31) NOT NULL,
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `permissao` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `tipo_logradouro` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `rg` varchar(255) DEFAULT NULL,
  `setor` varchar(255) DEFAULT NULL,
  `resultado` varchar(255) DEFAULT NULL,
  `resultado_txt` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

LOCK TABLES `usuario` WRITE;
INSERT INTO `usuario` VALUES 
('Funcionario',1,'admin@gmail.com','ADMIN','827ccb0eea8a706c4c34a16891f84e7b','111.111.111-11','Jd. Teste','Guarulhos','A-21','Teste logradouro','284','Av','SP','Senhor Administrador','36.222.113-4','Teste Administrador',NULL,NULL,NULL),
('Funcionario',2,'func@gmail.com','FUNC','827ccb0eea8a706c4c34a16891f84e7b','387.322.048-07','Jd. Teste','Guarulhos','B-23','Teste logradouro','284','Av','SP','Senhor Funcionário','36.222.112-4','Teste Func',NULL,NULL,NULL);
UNLOCK TABLES;
