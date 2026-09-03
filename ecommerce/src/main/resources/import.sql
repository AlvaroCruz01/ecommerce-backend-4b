/* === 1. TABELA CATEGORIA === */
INSERT INTO categoria (nome, descricao) VALUES ('Informática', 'Produtos de Informática');
INSERT INTO categoria (nome, descricao) VALUES ('Móveis e Escritório', 'Móveis e acessórios para escritório');


/* === 2. TABELA PRODUTO === */
INSERT INTO produto(id, nome, descricao, preco, estoque, categoria_Id) VALUES (101, 'Mouse Gamer RGB', 'Mouse óptico 3200 DPI com botões laterais', 75.25, 50, 1);

INSERT INTO produto(id, nome, descricao, preco, estoque, categoria_Id) VALUES (102, 'Teclado Sem Fio', 'Teclado slim layout ABNT2 conexão Bluetooth', 89.90, 30, 1);

INSERT INTO produto(id, nome, descricao, preco, estoque, categoria_Id) VALUES (103, 'Cadeira Escritório', 'Cadeira ergonômica com regulagem de altura', 300.00, 12, 2);

INSERT INTO produto(id, nome, descricao, preco, estoque, categoria_Id) VALUES (104, 'Luminária de Mesa', 'Luminária LED articulada com 3 níveis de luz', 120.00, 25, 2);

INSERT INTO produto(id, nome, descricao, preco, estoque, categoria_Id) VALUES (105, 'Fone de Ouvido Bluetooth', 'Fone intra-auricular com isolamento acústico', 199.90, 40, 1);


/* === 3. TABELA CLIENTE === */
INSERT INTO cliente(nome, email, telefone) VALUES ('Murilo', 'murilogabriel321@gmail.com', '+55 14 997386832');

INSERT INTO cliente(nome, email, telefone) VALUES ('Mariana Sousa', 'mariana.sousa@outlook.com', '+55 11 982341122');

INSERT INTO cliente(nome, email, telefone) VALUES ('Ricardo Alves', 'ricardo.alves@yahoo.com.br', '+55 21 971158899');

INSERT INTO cliente(nome, email, telefone) VALUES ('Beatriz Cruz', 'beatriz.cruz@hotmail.com', '+55 31 995443377');

INSERT INTO cliente(nome, email, telefone) VALUES ('Carlos Oliveira', 'carlos.oliveira@gmail.com', '+55 41 991223344');


/* === 4. TABELA PEDIDO === */
INSERT INTO pedido(data, status, valor_Total, cliente_Id) VALUES ('2026-09-02', 'Entregue', 150.50, 1);

INSERT INTO pedido(data, status, valor_Total, cliente_Id) VALUES ('2026-09-02', 'Processando', 89.90, 2);

INSERT INTO pedido(data, status, valor_Total, cliente_Id) VALUES ('2026-09-01', 'Cancelado', 420.00, 3);

INSERT INTO pedido(data, status, valor_Total, cliente_Id) VALUES ('2026-09-02', 'Enviado', 215.40, 4);

INSERT INTO pedido(data, status, valor_Total, cliente_Id) VALUES ('2026-09-02', 'Processando', 199.90, 5);


/* === 5. TABELA ITEMPEDIDO === */
INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (2, 75.25, 1, 101);

INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (1, 89.90, 2, 102);

INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (1, 300.00, 3, 103);

INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (1, 120.00, 3, 104);

INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (2, 107.70, 4, 101);

INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (1, 199.90, 5, 105);


/* === TABELA: PAGAMENTO === */
INSERT INTO pagamento(valor, data, status, tipo, pedido_Id) VALUES (150.50, '2026-09-02', 'Concluído', 'Cartão de Crédito', 1);

INSERT INTO pagamento(valor, data, status, tipo, pedido_Id) VALUES (89.90, '2026-09-02', 'Pendente', 'Pix', 2);

INSERT INTO pagamento(valor, data, status, tipo, pedido_Id) VALUES (420.00, '2026-09-01', 'Estornado', 'Boleto', 3);

INSERT INTO pagamento(valor, data, status, tipo, pedido_Id) VALUES (215.40, '2026-09-02', 'Concluído', 'Pix', 4);

INSERT INTO pagamento(valor, data, status, tipo, pedido_Id) VALUES (199.90, '2026-09-02', 'Pendente', 'Cartão de Crédito', 5);
