INSERT INTO pelicula_entity(nombre, genero, duracion) VALUES ('El Cuaderno de Sara','Drama','2 horas 10 minutos');
INSERT INTO pelicula_entity(nombre, genero, duracion) VALUES ('Sombra en la Ciudad','Suspenso','1 hora 45 minutos');
INSERT INTO pelicula_entity(nombre, genero, duracion) VALUES ('Batman','Accion','2 horas 15 minutos');
INSERT INTO pelicula_entity(nombre, genero, duracion) VALUES ('Orgullo y Prejuicio','Romance','2 horas 15 minutos');
INSERT INTO pelicula_entity(id, nombre, genero, duracion) VALUES (10,'Spiderman','Accion','2 horas 15 minutos');
INSERT INTO cliente_entity(identificacion, nombres, apellidos, direccion, telefono_fijo, telefono_movil) VALUES ('31274274', 'Argenis', 'Gomez Grajales', 'Calle 8 con 7', '2222222', '3175181818');
INSERT INTO cliente_entity(identificacion, nombres, apellidos, direccion, telefono_fijo, telefono_movil) VALUES ('94444555', 'Alexander', 'Lozada Avila', 'Calle 2B con 81A', '4445566', '3166998877');
INSERT INTO cliente_entity(id, identificacion, nombres, apellidos, direccion, telefono_fijo, telefono_movil) VALUES (11, '22888999', 'Argenis', 'Gomez Grajales', 'Calle 8 con 7', '2222222', '3175181818');
INSERT INTO cliente_entity(id, identificacion, nombres, apellidos, direccion, telefono_fijo, telefono_movil) VALUES (12, '94333222', 'Alexander', 'Lozada Avila', 'Calle 2B con 81A', '4445566', '3166998877');
INSERT INTO alquiler_entity(fecha_alquiler, fecha_entrega, fecha_registro, valor, id_cliente, id_pelicula) VALUES ('2020-11-13', '2020-11-16', '2020-11-13', 7000, 11, 1);
INSERT INTO alquiler_entity(fecha_alquiler, fecha_entrega, fecha_registro, valor, id_cliente, id_pelicula) VALUES ('2020-11-16', '2020-11-18', '2020-11-13', 5000, 12, 2);
INSERT INTO alquiler_entity(fecha_alquiler, fecha_entrega, fecha_registro, valor, id_cliente, id_pelicula) VALUES ('2020-11-13', '2020-11-16', '2020-11-13', 7000, 11, 3);