
-- Este es el código a ingresar en terminal para crear el contenedor MYSQL en Docker
-- docker pull mysql
-- docker run --name DulceHogar -e MYSQL_ROOT_PASSWORD=dulcehogar -p 3307:3306 -d mysql:latest



-- Este es el script SQL para crear la base de datos y las tablas

CREATE DATABASE DulceHogar;
USE DulceHogar;

CREATE TABLE socios (
    rut VARCHAR(12) PRIMARY KEY,
    nombre VARCHAR(50),
    ap_paterno VARCHAR(50),
    ap_materno VARCHAR(50),
    telefono VARCHAR(15),
    domicilio VARCHAR(100),
    comuna VARCHAR(50),
    ciudad VARCHAR(50),
    region VARCHAR(50),
    correo VARCHAR(100),
    numero_socio INT UNIQUE
);


CREATE TABLE cuentas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_socio INT NOT NULL,
    valor_cuota INT NOT NULL,
    cantidad_aportada INT NOT NULL,
    FOREIGN KEY (numero_socio) REFERENCES socios(numero_socio)
);


-- Tabla para los usuarios y sus contraseñas

CREATE TABLE usuario (
	rut VARCHAR(12) PRIMARY KEY,
    password VARCHAR(20) NOT NULL
);


-- Usuario y contraseña para iniciar sesión

INSERT INTO usuario (rut, password) VALUES ('12.345.678-9', 'dulcehogar');


