/* === 1. TABELA CATEGORIA === */
INSERT INTO categoria (nome, descricao)
VALUES ('Informática', 'Produtos de informática');

INSERT INTO categoria (nome, descricao)
VALUES ('Móveis e Escritório', 'Móveis e acessórios para escritório');

INSERT INTO categoria (nome, descricao)
VALUES ('Acessórios', 'Acessórios para computadores e eletrônicos');

INSERT INTO categoria (nome, descricao)
VALUES ('Eletrônicos', 'Produtos eletrônicos');

INSERT INTO categoria (nome, descricao)
VALUES ('Periféricos', 'Periféricos para computadores');


/* === 2. TABELA PRODUTO === */
INSERT INTO produto(nome, descricao, preco, estoque, categoria_Id)
VALUES ('Mouse Gamer RGB', 'Mouse óptico 3200 DPI com botões laterais', 75.25, 50, 8);

INSERT INTO produto(nome, descricao, preco, estoque, categoria_Id)
VALUES ('Teclado Sem Fio', 'Teclado slim layout ABNT2 conexão Bluetooth', 89.90, 30, 9);

INSERT INTO produto(nome, descricao, preco, estoque, categoria_Id)
VALUES ('Cadeira Escritório', 'Cadeira ergonômica com regulagem de altura', 300.00, 12, 10);

INSERT INTO produto(nome, descricao, preco, estoque, categoria_Id)
VALUES ('Luminária de Mesa', 'Luminária LED articulada com 3 níveis de luz', 120.00, 25, 11);

INSERT INTO produto(nome, descricao, preco, estoque, categoria_Id)
VALUES ('Fone de Ouvido Bluetooth', 'Fone intra-auricular com isolamento acústico', 199.90, 40, 12);


/* === 3. TABELA CLIENTE === */
INSERT INTO cliente(nome, email, telefone)
VALUES ('Murilo', 'murilogabriel321@gmail.com', '+55 14 997386832');

INSERT INTO cliente(nome, email, telefone)
VALUES ('Mariana Sousa', 'mariana.sousa@outlook.com', '+55 11 982341122');

INSERT INTO cliente(nome, email, telefone)
VALUES ('Ricardo Alves', 'ricardo.alves@yahoo.com.br', '+55 21 971158899');

INSERT INTO cliente(nome, email, telefone)
VALUES ('Beatriz Cruz', 'beatriz.cruz@hotmail.com', '+55 31 995443377');

INSERT INTO cliente(nome, email, telefone)
VALUES ('Carlos Oliveira', 'carlos.oliveira@gmail.com', '+55 41 991223344');


/* === 4. TABELA PEDIDO === */
INSERT INTO pedido(data, status, valor_Total, cliente_Id)
VALUES ('2026-09-02', 'Entregue', 150.50, 6);

INSERT INTO pedido(data, status, valor_Total, cliente_Id)
VALUES ('2026-09-02', 'Processando', 89.90, 7);

INSERT INTO pedido(data, status, valor_Total, cliente_Id)
VALUES ('2026-09-01', 'Cancelado', 420.00, 8);

INSERT INTO pedido(data, status, valor_Total, cliente_Id)
VALUES ('2026-09-02', 'Enviado', 215.40, 9);

INSERT INTO pedido(data, status, valor_Total, cliente_Id)
VALUES ('2026-09-02', 'Processando', 199.90, 10);


/* === 5. TABELA ITEMPEDIDO === */
INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id)
VALUES (2, 75.25, 8, 109);

INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id)
VALUES (1, 89.90, 9, 110);

INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id)
VALUES (1, 300.00, 10, 111);

INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id)
VALUES (1, 120.00, 11, 112);

INSERT INTO item_pedido(quantidade, valor_Unitario, pedido_Id, produto_Id)
VALUES (2, 107.70, 13, 113);


/* === 6. TABELA PAGAMENTO === */
INSERT INTO pagamento(valor, data, status, tipo, pedido_Id)
VALUES (150.50, '2026-09-02', 'Concluído', 'Cartão de Crédito', 8);

INSERT INTO pagamento(valor, data, status, tipo, pedido_Id)
VALUES (89.90, '2026-09-02', 'Pendente', 'Pix', 9);

INSERT INTO pagamento(valor, data, status, tipo, pedido_Id)
VALUES (420.00, '2026-09-01', 'Estornado', 'Boleto', 10);

INSERT INTO pagamento(valor, data, status, tipo, pedido_Id)
VALUES (215.40, '2026-09-02', 'Concluído', 'Pix', 11);

INSERT INTO pagamento(valor, data, status, tipo, pedido_Id)
VALUES (199.90, '2026-09-02', 'Pendente', 'Cartão de Crédito', 13);
