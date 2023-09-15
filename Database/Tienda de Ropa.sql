-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema TiendaModa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TiendaModa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TiendaModa` DEFAULT CHARACTER SET utf8 ;
USE `TiendaModa` ;

-- -----------------------------------------------------
-- Table `TiendaModa`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TiendaModa`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(45) NOT NULL,
  `Tipo` ENUM('Final', 'Administrador') NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TiendaModa`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TiendaModa`.`perfil` (
  `id_Perfil` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fechaNac` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `biilletera` DECIMAL(10,2) NOT NULL,
  `domicilio` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `foto` VARCHAR(45) NULL,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_Perfil`),
  INDEX `fk_Perfil_Usuario_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_Perfil_Usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `TiendaModa`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TiendaModa`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TiendaModa`.`producto` (
  `id_Producto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `categoria` ENUM('Zapatillas', 'Ojotas', 'Zapatos', 'Pantalon', 'Pollera', 'Remera', 'Campera', 'Buzo', 'Guantes', 'Gorro') NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `stock` INT NOT NULL,
  `descripcion` VARCHAR(90) NULL,
  PRIMARY KEY (`id_Producto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TiendaModa`.`registroCompras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TiendaModa`.`registroCompras` (
  `id_RegistroCompras` INT NOT NULL AUTO_INCREMENT,
  `id_perfil` INT NOT NULL,
  PRIMARY KEY (`id_RegistroCompras`),
  INDEX `fk_RegistroCompras_Perfil1_idx` (`id_perfil` ASC) VISIBLE,
  CONSTRAINT `fk_RegistroCompras_Perfil1`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `TiendaModa`.`perfil` (`id_Perfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TiendaModa`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TiendaModa`.`compra` (
  `id_Compra` INT NOT NULL AUTO_INCREMENT,
  `id_RegistroCompras` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `montoTotal` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id_Compra`),
  INDEX `fk_RegistroCompra_has_Producto_RegistroCompra1_idx` (`id_RegistroCompras` ASC) VISIBLE,
  CONSTRAINT `fk_RegistroCompra_has_Producto_RegistroCompra1`
    FOREIGN KEY (`id_RegistroCompras`)
    REFERENCES `TiendaModa`.`registroCompras` (`id_RegistroCompras`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TiendaModa`.`compra_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TiendaModa`.`compra_producto` (
  `id_compra_producto` INT NOT NULL AUTO_INCREMENT,
  `compra_Id_Compra` INT NOT NULL,
  `producto_Id_Producto` INT NOT NULL,
  `cantidad` INT NOT NULL,
  INDEX `fk_Compra_has_Producto_Producto1_idx` (`producto_Id_Producto` ASC) VISIBLE,
  INDEX `fk_Compra_has_Producto_Compra1_idx` (`compra_Id_Compra` ASC) VISIBLE,
  PRIMARY KEY (`id_compra_producto`),
  CONSTRAINT `fk_Compra_has_Producto_Compra1`
    FOREIGN KEY (`compra_Id_Compra`)
    REFERENCES `TiendaModa`.`compra` (`id_Compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_has_Producto_Producto1`
    FOREIGN KEY (`producto_Id_Producto`)
    REFERENCES `TiendaModa`.`producto` (`id_Producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
