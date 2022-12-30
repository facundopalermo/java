/*TABLA USUARIOS*/:

CREATE TABLE usuarios ( id INTEGER IDENTITY, user VARCHAR(25) UNIQUE, pass VARCHAR(25), email VARCHAR(50), nombre VARCHAR(25) , apellido VARCHAR(25), tipo INT(1))

CREATE TABLE edificios ( id INTEGER IDENTITY UNIQUE, nombre VARCHAR(25) UNIQUE, calle VARCHAR(25), altura INT(5), localidad VARCHAR(25), pisos INT(5))

CREATE TABLE UF ( id INTEGER IDENTITY UNIQUE, edificio int(5), U INT(5), F INT(5), mc INT(10), ocupante VARCHAR(100))

CREATE TABLE movimiento (id INTEGER IDENTITY UNIQUE, edificio INT(5), fecha DATE, detalle VARCHAR(100), entrada float DEFAULT 0, salida float DEFAULT 0)

CREATE TABLE expensas (id INTEGER IDENTITY UNIQUE, uf INT(5), mes INT, anio INT, deuda double, interesDeuda float, expensaActual float, total float, pago float, fechaPago DATE )