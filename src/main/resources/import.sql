INSERT INTO Campus (id_campus, city, address) VALUES (1, 'Latacunga', 'Belisario Quevedo');
INSERT INTO Campus (id_campus, city, address) VALUES (2, 'Quito', 'Sangolquí');
INSERT INTO Campus (id_campus, city, address) VALUES (3, 'Ambato', 'Ficoa');

INSERT INTO Students (id_student, first_name, last_name, fk_campus) VALUES (1, 'Roberto', 'Barahona', 1);
INSERT INTO Students (id_student, first_name, last_name, fk_campus) VALUES (2, 'Cristina', 'Barahona', 2);
INSERT INTO Students (id_student, first_name, last_name, fk_campus) VALUES (3, 'Andrea', 'Barahona', 3);

INSERT INTO Signatures (id_signature, title, hours, fk_student) VALUES (1, 'Programación', '55', 1);
INSERT INTO Signatures (id_signature, title, hours, fk_student) VALUES (2, 'Patrones de diseño', '35', 2);
INSERT INTO Signatures (id_signature, title, hours, fk_student) VALUES (3, 'Certificación', '33', 3);