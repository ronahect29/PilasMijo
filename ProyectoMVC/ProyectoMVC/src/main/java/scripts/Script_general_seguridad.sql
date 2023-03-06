CREATE SCHEMA IF NOT EXISTS `proyectop312023` DEFAULT CHARACTER SET utf8 ;
USE `proyectop312023`;


CREATE TABLE IF NOT EXISTS tbl_usuario (
	usuid INT NOT NULL AUTO_INCREMENT,
	usunombre VARCHAR(45) NOT NULL,
	usucontrasena VARCHAR(25) NOT NULL,
	PRIMARY KEY (usuid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_Sedes (
	sedeid INT NOT NULL AUTO_INCREMENT,
	sedenombre VARCHAR(45) NOT NULL,
	sedeEstatus VARCHAR(25) NOT NULL,
	PRIMARY KEY (sedeid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_alumnos (
	alumnoscarnet INT NOT NULL AUTO_INCREMENT,
	alumnosnombre VARCHAR(45) NOT NULL,
	alumnostelefono VARCHAR(25) NOT NULL,
        alumnosdireccion VARCHAR(45) NOT NULL,
        alumnosemail VARCHAR(45) NOT NULL,
        alumnosestatus VARCHAR(25) NOT NULL,
	PRIMARY KEY (alumnoscarnet) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_maestros (
	maestrosid INT NOT NULL AUTO_INCREMENT,
	maestrosnombre VARCHAR(45) NOT NULL,
	maestros VARCHAR(25) NOT NULL,
	PRIMARY KEY (maestrosid) )
ENGINE = InnoDB CHARACTER SET = latin1;