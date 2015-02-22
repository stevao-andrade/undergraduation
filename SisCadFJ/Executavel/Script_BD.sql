SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `forcajr` DEFAULT CHARACTER SET latin1 ;
USE `forcajr` ;

-- -----------------------------------------------------
-- Table `forcajr`.`alterados`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `forcajr`.`alterados` (
  `idSocioPK` INT(11) NOT NULL AUTO_INCREMENT ,
  `idSocio` INT(11) NOT NULL ,
  `nomeSocio` VARCHAR(60) NOT NULL ,
  `cpfSocio` VARCHAR(20) NOT NULL ,
  `rgSocio` BIGINT(20) NOT NULL ,
  `matSocio` VARCHAR(10) NOT NULL ,
  `sexoSocio` VARCHAR(10) NOT NULL ,
  `diaNascSocio` INT(11) NOT NULL ,
  `mesNascSocio` VARCHAR(15) NOT NULL ,
  `anoNascSocio` INT(11) NOT NULL ,
  `enderecoSocio` VARCHAR(50) NOT NULL ,
  `numEndSocio` VARCHAR(10) NOT NULL ,
  `bairroSocio` VARCHAR(45) NOT NULL ,
  `cidadeSocio` VARCHAR(45) NOT NULL ,
  `foneSocio` VARCHAR(20) NOT NULL ,
  `celSocio` VARCHAR(20) NOT NULL ,
  `emailSocio` VARCHAR(45) NOT NULL ,
  `estadoSocio` VARCHAR(45) NOT NULL ,
  `blocoSocio` VARCHAR(2) NOT NULL ,
  `funcaoSocio` VARCHAR(50) NOT NULL ,
  `data` TIMESTAMP NULL DEFAULT NULL ,
  PRIMARY KEY (`idSocioPK`) ,
  UNIQUE INDEX `idSocioPK_UNIQUE` (`idSocioPK` ASC) )
ENGINE = MyISAM
AUTO_INCREMENT = 156
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `forcajr`.`habilidades`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `forcajr`.`habilidades` (
  `idHab` INT(11) NOT NULL AUTO_INCREMENT ,
  `nomeHabilidade` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idHab`) )
ENGINE = MyISAM
AUTO_INCREMENT = 52
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `forcajr`.`outros`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `forcajr`.`outros` (
  `idOutros` INT(11) NOT NULL AUTO_INCREMENT ,
  `fkIdSocio` INT(11) NOT NULL ,
  `outros` VARCHAR(400) NULL DEFAULT NULL ,
  PRIMARY KEY (`idOutros`) ,
  INDEX `fkIdSocio` (`fkIdSocio` ASC) )
ENGINE = MyISAM
AUTO_INCREMENT = 49
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `forcajr`.`socio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `forcajr`.`socio` (
  `idSocio` INT(11) NOT NULL AUTO_INCREMENT ,
  `nomeSocio` VARCHAR(60) NOT NULL ,
  `cpfSocio` VARCHAR(100) NOT NULL ,
  `rgSocio` BIGINT(20) NOT NULL ,
  `matSocio` VARCHAR(10) NOT NULL ,
  `sexoSocio` VARCHAR(10) NOT NULL ,
  `diaNascSocio` INT(11) NOT NULL ,
  `mesNascSocio` VARCHAR(15) NOT NULL ,
  `anoNascSocio` INT(11) NOT NULL ,
  `enderecoSocio` VARCHAR(50) NOT NULL ,
  `numEndSocio` VARCHAR(10) NOT NULL ,
  `bairroSocio` VARCHAR(45) NOT NULL ,
  `cidadeSocio` VARCHAR(45) NOT NULL ,
  `foneSocio` VARCHAR(20) NOT NULL ,
  `celSocio` VARCHAR(20) NOT NULL ,
  `emailSocio` VARCHAR(45) NOT NULL ,
  `estadoSocio` VARCHAR(45) NOT NULL ,
  `blocoSocio` VARCHAR(2) NOT NULL ,
  `funcaoSocio` VARCHAR(50) NOT NULL ,
  `data` TIMESTAMP NULL DEFAULT NULL ,
  PRIMARY KEY (`idSocio`) ,
  UNIQUE INDEX `idSocio_UNIQUE` (`idSocio` ASC) )
ENGINE = MyISAM
AUTO_INCREMENT = 58
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `forcajr`.`sociohab`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `forcajr`.`sociohab` (
  `FkIdSocio` INT(11) NOT NULL DEFAULT '0' ,
  `FkIdHab` INT(11) NOT NULL DEFAULT '0' ,
  `nomeHabilidade` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`FkIdSocio`, `FkIdHab`) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `forcajr`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `forcajr`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nomeUsuario` VARCHAR(45) NOT NULL ,
  `senhaUsuario` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = MyISAM
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------
-- Table `forcajr`.`habilidades`
-- -----------------------------------------------------
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('Banco de Dados');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('CSS');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('C');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('IA');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('Java');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('Suporte');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('Delphi');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('Design');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('HTML');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('PHP');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('Redes');
INSERT INTO `forcajr`.`habilidades` (`nomeHabilidade`) VALUES ('Ruby');


-- -----------------------------------------------------
-- Table `forcajr`.`alterados`
-- -----------------------------------------------------

INSERT INTO `forcajr`.`alterados` (`nomeSocio`, `cpfSocio`, `rgSocio`, `matSocio`, `sexoSocio`, `diaNascSocio`, `mesNascSocio`, `anoNascSocio`, `enderecoSocio`, `numEndSocio`, `bairroSocio`, `cidadeSocio`, `foneSocio`, `celSocio`, `emailSocio`, `estadoSocio`, `blocoSocio`, `funcaoSocio`) VALUES ('MOC', '000.000.000-00', 0000000, '00000000', 'Masculino', 18, 'Abril', 1987, 'Rua MOC', '123', 'MOC', 'MOC', '(00)0000-0000', '(00)0000-0000', 'moc@moc.com', 'Piaui - PI', '--', 'Colaborador');



-- -----------------------------------------------------
-- Table `forcajr`.`usuario`
-- -----------------------------------------------------


INSERT INTO `forcajr`.`usuario` (`nomeUsuario`, `senhaUsuario`) VALUES ('fjinformatica', 'master');