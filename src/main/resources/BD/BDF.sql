CREATE DATABASE SISTEMA_CAF;
USE SISTEMA_CAF;
CREATE TABLE TRABAJADORES(
ID INT AUTO_INCREMENT NOT NULL,
NOMBRE VARCHAR(30) NOT NULL,
APELLIDOS VARCHAR(30) NOT NULL,
EDAD INT NOT NULL,
NUMERO_TELEFONICO VARCHAR(10) NOT NULL,
CURP VARCHAR(18) NOT NULL,
RFC VARCHAR(13) NOT NULL,
NSS VARCHAR(11) NOT NULL,
CATEGORIA VARCHAR(30) NOT NULL,
FECHA_REGISTRO DATE NOT NULL,
HORA_ENTRADA TIME NOT NULL,
HORA_SALIDA TIME NOT NULL,
SALARIO FLOAT NOT NULL,
CORREO VARCHAR(30) NOT NULL,
CLAVE VARCHAR(255) NOT NULL,
ESTATUS BOOLEAN NOT NULL,
PRIMARY KEY(ID)
);

CREATE TABLE MEMBRESIAS(
ID INT AUTO_INCREMENT NOT NULL,
NOMBRE VARCHAR(30) NOT NULL,
PRECIO FLOAT NOT NULL,
FECHA_PAGO DATE NOT NULL,
PROXIMO_PAGO DATE NOT NULL,
MIEMBROS_TOTALES INT NOT NULL,
MIEMBROS_ACTUALES INT NOT NULL,
ESTATUS BOOLEAN NOT NULL,
PRIMARY KEY(ID)
);

CREATE TABLE CLIENTES(
ID INT AUTO_INCREMENT NOT NULL,
NOMBRE VARCHAR(30) NOT NULL,
APELLIDOS VARCHAR(30) NOT NULL,
EDAD INT NOT NULL,
NUMERO_TELEFONICO VARCHAR(10) NOT NULL,
FECHA_REGISTRO DATE NOT NULL,
CORREO VARCHAR(30) NOT NULL,
CLAVE VARCHAR(255) NOT NULL,
MEMBRESIA_ID INT,
ESTATUS BOOLEAN NOT NULL,
PRIMARY KEY(ID),
CONSTRAINT FK_CLIENTE_MEMBRESIA
	FOREIGN KEY(MEMBRESIA_ID)
	REFERENCES MEMBRESIAS(ID)
);

CREATE TABLE EQUIPOS(
ID INT NOT NULL,
NOMBRE VARCHAR(30) NOT NULL,
MODELO VARCHAR(30) NOT NULL,
SERIE VARCHAR(30) NOT NULL,
ULTIMO_MANTENIMIENTO DATE,
ESTATUS BOOLEAN NOT NULL,
ESTATUS_RENTA BOOLEAN NOT NULL,
PRIMARY KEY(ID)
);

CREATE TABLE PLANES(
ID INT AUTO_INCREMENT NOT NULL,
ACTIVIDAD VARCHAR(255) NOT NULL,
DESCRIPCION VARCHAR(255) NOT NULL,
TIPO VARCHAR(30) NOT NULL,
FECHA_CREACION DATE NOT NULL,
HORA_CREACION TIME NOT NULL,
FECHA_REALIZACION DATE,
HORA_REALIZACION TIME,
CREADOR_ID INT NOT NULL,
EQUIPO_ID INT,
ESTATUS BOOLEAN NOT NULL,
PRIMARY KEY(ID),
CONSTRAINT FK_PLAN_TRABAJADOR
	FOREIGN KEY (CREADOR_ID)
	REFERENCES TRABAJADORES(ID),
CONSTRAINT FK_PLAN_EQUIPO
	FOREIGN KEY(EQUIPO_ID)
	REFERENCES EQUIPOS(ID)
);

CREATE TABLE RENTAS(
ID INT NOT NULL,
CLIENTE_ID INT NOT NULL,
EQUIPO_ID INT NOT NULL,
FECHA_RENTA DATE NOT NULL,
HORA_INICIO TIME NOT NULL,
HORA_TERMINO TIME NOT NULL,
PRECIO FLOAT NOT NULL,
ESTATUS BOOLEAN NOT NULL,
PRIMARY KEY(ID),
CONSTRAINT FK_RENTA_CLIENTE
	FOREIGN KEY(CLIENTE_ID)
	REFERENCES CLIENTES(ID),
CONSTRAINT FK_RENTA_EQUIPO
	FOREIGN KEY(EQUIPO_ID)
	REFERENCES EQUIPOS(ID)
);

