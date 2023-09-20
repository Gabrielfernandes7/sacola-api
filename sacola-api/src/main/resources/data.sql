INSERT INTO restaurante (id, cep, complemento, nome) VALUES
(1L, '0000001', 'Complemento Endereço Restaurante 1'),
(2L, '0000002', 'Complemento Endereço Restaurante 2');

INSERT INTO clientes (id, cep, complemento, nome) VALUES
(1L, '0000001', 'Complemento Endereço Restaurante 1', 'Cliente 1');

INSERT INTO produto (id, disponivel, nome, valor_unitario, restaurante_id) VALUES
(1L, true, 'Porduto 1', 5.0, 1L),
(2L, true, 'Porduto 1', 6.0, 1L),
(3L, true, 'Porduto 1', 7.0, 2L);

INSERT INTO sacola (id, forma_pagamento, fechada, valor_total, cliente_id) VALUES
(1L, 0, false, 0.0, 1L);