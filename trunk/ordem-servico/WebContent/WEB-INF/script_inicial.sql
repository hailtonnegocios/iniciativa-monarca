Use ordem_servico; 
 
CREATE TABLE 'usuario' ( 
'id_usuario' bigint(20) NOT NULL AUTO_INCREMENT, 
'email' varchar(255) DEFAULT NULL, 
'permissao' varchar(255) DEFAULT NULL, 
'senha' varchar(255) DEFAULT NULL, 
PRIMARY KEY ('id_usuario') 
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1; 
 
INSERT INTO 'usuario' VALUES (1,'usuarioteste@gmail.com','ADMIN','12345'); 