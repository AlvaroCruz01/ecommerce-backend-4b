-- CATEGORIA
INSERT INTO categoria (id, nome, descricao) VALUES (1, 'Informática', 'Produtos de informática');
INSERT INTO categoria (id, nome, descricao) VALUES (2, 'Móveis e Escritório', 'Móveis e acessórios para escritório');
INSERT INTO categoria (id, nome, descricao) VALUES (3, 'Acessórios', 'Acessórios para computadores e eletrônicos');
INSERT INTO categoria (id, nome, descricao) VALUES (4, 'Eletrônicos', 'Produtos eletrônicos');
INSERT INTO categoria (id, nome, descricao) VALUES (5, 'Periféricos', 'Periféricos para computadores');


-- PRODUTO
INSERT INTO produto(id, nome, descricao, preco, estoque, categoria_Id) VALUES (1, 'Mouse Gamer RGB', 'Mouse óptico 3200 DPI com botões laterais', 75.25, 50, 5);
INSERT INTO produto(id, nome, descricao, preco, estoque, categoria_Id) VALUES (2, 'Teclado Sem Fio', 'Teclado slim layout ABNT2 conexão Bluetooth', 89.90, 30, 5);
INSERT INTO produto(id, nome, descricao, preco, estoque, categoria_Id) VALUES (3, 'Cadeira Escritório', 'Cadeira ergonômica com regulagem de altura', 300.00, 12, 2);
INSERT INTO produto(id, nome, descricao, preco, estoque, categoria_Id) VALUES (4, 'Luminária de Mesa', 'Luminária LED articulada com 3 níveis de luz', 120.00, 25, 2);
INSERT INTO produto(id, nome, descricao, preco, estoque, categoria_Id) VALUES (5, 'Fone de Ouvido Bluetooth', 'Fone intra-auricular com isolamento acústico', 199.90, 40, 3);


-- CLIENTE
INSERT INTO cliente(id, nome, email, telefone) VALUES (1, 'Murilo', 'murilogabriel321@gmail.com', '+55 14 997386832');
INSERT INTO cliente(id, nome, email, telefone) VALUES (2, 'Mariana Sousa', 'mariana.sousa@outlook.com', '+55 11 982341122');
INSERT INTO cliente(id, nome, email, telefone) VALUES (3, 'Ricardo Alves', 'ricardo.alves@yahoo.com.br', '+55 21 971158899');
INSERT INTO cliente(id, nome, email, telefone) VALUES (4, 'Beatriz Cruz', 'beatriz.cruz@hotmail.com', '+55 31 995443377');
INSERT INTO cliente(id, nome, email, telefone) VALUES (5, 'Carlos Oliveira', 'carlos.oliveira@gmail.com', '+55 41 991223344');


-- PEDIDO
INSERT INTO pedido(id, data, status, valor_Total, cliente_Id) VALUES (1, '2026-09-02', 'Entregue', 150.50, 1);
INSERT INTO pedido(id, data, status, valor_Total, cliente_Id) VALUES (2, '2026-09-02', 'Processando', 89.90, 2);
INSERT INTO pedido(id, data, status, valor_Total, cliente_Id) VALUES (3, '2026-09-01', 'Cancelado', 300.00, 3);
INSERT INTO pedido(id, data, status, valor_Total, cliente_Id) VALUES (4, '2026-09-02', 'Enviado', 120.00, 4);
INSERT INTO pedido(id, data, status, valor_Total, cliente_Id) VALUES (5, '2026-09-02', 'Processando', 199.90, 5);


-- ITEMPEDIDO
INSERT INTO item_pedido(id, quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (1, 2, 75.25, 1, 1);
INSERT INTO item_pedido(id, quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (2, 1, 89.90, 2, 2);
INSERT INTO item_pedido(id, quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (3, 1, 300.00, 3, 3);
INSERT INTO item_pedido(id, quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (4, 1, 120.00, 4, 4);
INSERT INTO item_pedido(id, quantidade, valor_Unitario, pedido_Id, produto_Id) VALUES (5, 1, 199.90, 5, 5);


-- PAGAMENTO
INSERT INTO pagamento(id, valor, data, status, tipo, pedido_Id) VALUES (1, 150.50, '2026-09-02', 'Concluído', 'Cartão de Crédito', 1);
INSERT INTO pagamento(id, valor, data, status, tipo, pedido_Id) VALUES (2, 89.90, '2026-09-02', 'Pendente', 'Pix', 2);
INSERT INTO pagamento(id, valor, data, status, tipo, pedido_Id) VALUES (3, 300.00, '2026-09-01', 'Estornado', 'Boleto', 3);
INSERT INTO pagamento(id, valor, data, status, tipo, pedido_Id) VALUES (4, 120.00, '2026-09-02', 'Concluído', 'Pix', 4);
INSERT INTO pagamento(id, valor, data, status, tipo, pedido_Id) VALUES (5, 199.90, '2026-09-02', 'Pendente', 'Cartão de Crédito', 5);
