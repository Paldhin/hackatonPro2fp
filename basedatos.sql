-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Gestor_hoteles
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Gestor_hoteles
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Gestor_hoteles` DEFAULT CHARACTER SET utf8 ;
USE `Gestor_hoteles` ;

-- -----------------------------------------------------
-- Table `Gestor_hoteles`.`Direcciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Gestor_hoteles`.`Direcciones` (
  `idDireccion` INT NOT NULL AUTO_INCREMENT,
  `Calle` VARCHAR(450) NULL,
  `Numero` VARCHAR(450) NULL,
  `Municipio` VARCHAR(450) NULL,
  `Pais` VARCHAR(450) NULL,
  `Codigo_Postal` VARCHAR(450) NULL,
  `Puerta` VARCHAR(450) NULL,
  `Ciudad` VARCHAR(45) NULL,
  PRIMARY KEY (`idDireccion`),
  UNIQUE INDEX `idDireccion_UNIQUE` (`idDireccion` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Gestor_hoteles`.`Hoteles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Gestor_hoteles`.`Hoteles` (
  `idHotel` INT NOT NULL AUTO_INCREMENT,
  `Direcciones_idDireccion` INT NOT NULL,
  `Nombre` VARCHAR(450) NOT NULL,
  `Telefono_contacto` VARCHAR(450) NULL,
  `Email_contacto` VARCHAR(450) NULL,
  `Web` VARCHAR(450) NULL,
  PRIMARY KEY (`idHotel`),
  UNIQUE INDEX `idHotel_UNIQUE` (`idHotel` ASC) VISIBLE,
  INDEX `fk_Hoteles_Direcciones1_idx` (`Direcciones_idDireccion` ASC) VISIBLE,
  CONSTRAINT `fk_Hoteles_Direcciones1`
    FOREIGN KEY (`Direcciones_idDireccion`)
    REFERENCES `Gestor_hoteles`.`Direcciones` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Gestor_hoteles`.`Habitaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Gestor_hoteles`.`Habitaciones` (
  `idHabitacion` INT NOT NULL AUTO_INCREMENT,
  `NumeroHabitacion` INT NOT NULL,
  `TipoHabitacion` VARCHAR(450) NOT NULL,
  `Hoteles_idHotel` INT NOT NULL,
  `Borrada` BIT NOT NULL,
  `Fecha_inicio_vigencia` DATETIME NOT NULL,
  `Fecha_borrado` DATETIME NULL,
  `Precio_habitacion_euros` DECIMAL UNSIGNED NULL,
  PRIMARY KEY (`idHabitacion`),
  UNIQUE INDEX `idHabitaciones_UNIQUE` (`idHabitacion` ASC) VISIBLE,
  INDEX `fk_Habitaciones_Hotel_idx` (`Hoteles_idHotel` ASC) VISIBLE,
  CONSTRAINT `fk_Habitaciones_Hotel`
    FOREIGN KEY (`Hoteles_idHotel`)
    REFERENCES `Gestor_hoteles`.`Hoteles` (`idHotel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Gestor_hoteles`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Gestor_hoteles`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Direcciones_idDireccion` INT NOT NULL,
  `Administrador` BIT NOT NULL,
  `Nombre_usuario` VARCHAR(450) NOT NULL,
  `Password` VARCHAR(450) NOT NULL,
  `Nombre` VARCHAR(450) NOT NULL,
  `DNI` VARCHAR(450) NOT NULL,
  `Apellido1` VARCHAR(450) NULL,
  `Apellido2` VARCHAR(450) NULL,
  `email` VARCHAR(450) NOT NULL,
  `telefono` VARCHAR(450) NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `idClientes_UNIQUE` (`idUsuario` ASC) VISIBLE,
  INDEX `fk_Clientes_Direcciones1_idx` (`Direcciones_idDireccion` ASC) VISIBLE,
  UNIQUE INDEX `Nombre_usuario_UNIQUE` (`Nombre_usuario` ASC) VISIBLE,
  UNIQUE INDEX `Password_UNIQUE` (`Password` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `fk_Clientes_Direcciones1`
    FOREIGN KEY (`Direcciones_idDireccion`)
    REFERENCES `Gestor_hoteles`.`Direcciones` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Gestor_hoteles`.`Reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Gestor_hoteles`.`Reservas` (
  `idReservas` INT NOT NULL AUTO_INCREMENT,
  `Clientes_idCliente` INT NOT NULL,
  `Habitaciones_idHabitacion` INT NOT NULL,
  `Cancelada` BIT NOT NULL,
  `Fecha_realizacion` DATETIME NOT NULL,
  `Momento_entrada` DATETIME NOT NULL,
  `Momento_salida` DATETIME NOT NULL,
  PRIMARY KEY (`idReservas`),
  UNIQUE INDEX `idReservas_UNIQUE` (`idReservas` ASC) VISIBLE,
  INDEX `fk_Reservas_Clientes1_idx` (`Clientes_idCliente` ASC) VISIBLE,
  INDEX `fk_Reservas_Habitaciones1_idx` (`Habitaciones_idHabitacion` ASC) VISIBLE,
  CONSTRAINT `fk_Reservas_Clientes1`
    FOREIGN KEY (`Clientes_idCliente`)
    REFERENCES `Gestor_hoteles`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservas_Habitaciones1`
    FOREIGN KEY (`Habitaciones_idHabitacion`)
    REFERENCES `Gestor_hoteles`.`Habitaciones` (`idHabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

DROP TRIGGER IF EXISTS `Gestor_hoteles`.`Habitaciones_AFTER_UPDATE`;

DELIMITER $$
USE `Gestor_hoteles`$$
CREATE DEFINER = CURRENT_USER TRIGGER `Gestor_hoteles`.`Habitaciones_AFTER_UPDATE` AFTER UPDATE ON `Habitaciones` FOR EACH ROW
BEGIN
	IF NEW.Borrada = 1
    THEN UPDATE `Gestor_hoteles`.`Habitaciones` SET `Fecha_borrado` = NOW() WHERE (`idHabitacion` = NEW.idHabitacion);
    END IF;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS `Gestor_hoteles`.`Reservas_AFTER_INSERT`;

DELIMITER $$
USE `Gestor_hoteles`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `Reservas_AFTER_INSERT` AFTER INSERT ON `Reservas` FOR EACH ROW BEGIN
	UPDATE `Gestor_hoteles`.`Reservas` SET `Fecha_realizacion` = NOW() WHERE (`idReservas` = NEW.idReservas);
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS `Gestor_hoteles`.`Habitaciones_AFTER_INSERT`;

DELIMITER $$
USE `Gestor_hoteles`$$
CREATE DEFINER = CURRENT_USER TRIGGER `Gestor_hoteles`.`Habitaciones_AFTER_INSERT` AFTER INSERT ON `Habitaciones` FOR EACH ROW
BEGIN
	UPDATE `Gestor_hoteles`.`Reservas` SET `Fecha_inicio_vigencia` = NOW() WHERE (`idHabitacion` = NEW.idHabitacion);
END$$
DELIMITER ;

