CREATE TABLE pagamentos (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 valor decimal(19,2) NOT NULL,
 nome varchar(100) DEFAULT NULL,
 status varchar(25) NOT NULL,
 forma_de_pagamento_id bigint(20) NOT NULL,
 pedido_id bigint(20) NOT NULL,
PRIMARY KEY (id)
);