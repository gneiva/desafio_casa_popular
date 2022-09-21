INSERT INTO familia  (nome) VALUES 
('Família A'),
('Família B'),
('Família C'),
('Família D'),
('Família E'),
('Família F'),
('Família G'),
('Família H');


INSERT INTO pessoa (nome, data_nascimento, renda, id_familia) VALUES 
 ('João', '1985-12-25', '9800.00', 	(SELECT id_familia FROM familia where nome = 'Família A')),
 ('Daiana', '1986-11-08', '0.0', 		(SELECT id_familia FROM familia where nome = 'Família A')),
 ('Arthur', '2022-02-22', '0.0',		(SELECT id_familia FROM familia where nome = 'Família A')),
 ('Davi', '2020-02-22', '0.0', 		(SELECT id_familia FROM familia where nome = 'Família A')),
 ('Levi', '2018-02-22', '0.0', 		(SELECT id_familia FROM familia where nome = 'Família A')),
 ('Zezinho', '1995-12-25', '800.00',	(SELECT id_familia FROM familia where nome = 'Família B')),
 ('Joana', '1999-11-08', '0.0', 		(SELECT id_familia FROM familia where nome = 'Família B')),
 ('Pedrinho', '2005-02-22', '0.0', 	(SELECT id_familia FROM familia where nome = 'Família B')),
 ('Goku', '1995-12-25', '800.00', 	(SELECT id_familia FROM familia where nome = 'Família C')),
 ('Paula', '1999-11-08', '500.0', 	(SELECT id_familia FROM familia where nome = 'Família C')),
 ('Kurinin', '2000-02-22', '0.0', 	(SELECT id_familia FROM familia where nome = 'Família C')),
 ('Vedita', '1995-12-25', '800.00', 	(SELECT id_familia FROM familia where nome = 'Família D')),
 ('Poca', '1999-11-08', '500.0', 		(SELECT id_familia FROM familia where nome = 'Família D')),
 ('Porã', '2010-02-22', '0.0', 		(SELECT id_familia FROM familia where nome = 'Família D')),
 ('Afonso', '1975-12-25', '900.00', 	(SELECT id_familia FROM familia where nome = 'Família E')),
 ('Cleide', '1960-11-08', '0.0', 		(SELECT id_familia FROM familia where nome = 'Família E')),
 ('Alberto', '1975-12-25', '900.00',	(SELECT id_familia FROM familia where nome = 'Família E')),
('Dani', '1960-11-08', '450.0', 		(SELECT id_familia FROM familia where nome = 'Família E')),
 ('Joaquim', '1985-12-25', '400.00', 	(SELECT id_familia FROM familia where nome = 'Família F')),
 ('Joana', '1986-11-08', '100.0', 		(SELECT id_familia FROM familia where nome = 'Família F')),
 ('Joaninha', '2022-02-22', '0.0',		(SELECT id_familia FROM familia where nome = 'Família F')),
 ('Joaninho', '2020-02-22', '0.0', 		(SELECT id_familia FROM familia where nome = 'Família F')),
 ('José', '2018-02-22', '0.0', 		(SELECT id_familia FROM familia where nome = 'Família F'));
  