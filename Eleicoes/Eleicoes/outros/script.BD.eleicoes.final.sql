SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `eleicoes` DEFAULT CHARACTER SET latin1 ;
USE `eleicoes` ;

-- -----------------------------------------------------
-- Table `eleicoes`.`administrador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eleicoes`.`administrador` (
  `codigo_administrador` INT(11) NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(255) NOT NULL ,
  `senha` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`codigo_administrador`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eleicoes`.`questionarios`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eleicoes`.`questionarios` (
  `codigo_questionario` INT(11) NOT NULL AUTO_INCREMENT ,
  `dataCriacao` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `nomeQuestionario` VARCHAR(255) NOT NULL ,
  `dataDisponibilidadeFinal` DATE NOT NULL ,
  PRIMARY KEY (`codigo_questionario`) )
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eleicoes`.`questoes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eleicoes`.`questoes` (
  `codigo_questao` INT(11) NOT NULL AUTO_INCREMENT ,
  `enunciadoQuestao` VARCHAR(255) NOT NULL ,
  `codigo_questionario` INT(11) NOT NULL ,
  PRIMARY KEY (`codigo_questao`) ,
  INDEX `FKBA82513B911BC697` (`codigo_questionario` ASC) ,
  CONSTRAINT `FKBA82513B911BC697`
    FOREIGN KEY (`codigo_questionario` )
    REFERENCES `eleicoes`.`questionarios` (`codigo_questionario` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eleicoes`.`alternativas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eleicoes`.`alternativas` (
  `codigo_alternativa` INT(11) NOT NULL AUTO_INCREMENT ,
  `enunciadoAlternativa` VARCHAR(255) NOT NULL ,
  `codigo_questao` INT(11) NOT NULL ,
  `codigo_questionario` INT(11) NOT NULL ,
  PRIMARY KEY (`codigo_alternativa`) ,
  INDEX `FK945FCDEA911BC697` (`codigo_questionario` ASC) ,
  INDEX `FK945FCDEA10448863` (`codigo_questao` ASC) ,
  CONSTRAINT `FK945FCDEA10448863`
    FOREIGN KEY (`codigo_questao` )
    REFERENCES `eleicoes`.`questoes` (`codigo_questao` )
    ON DELETE CASCADE,
  CONSTRAINT `FK945FCDEA911BC697`
    FOREIGN KEY (`codigo_questionario` )
    REFERENCES `eleicoes`.`questionarios` (`codigo_questionario` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 77
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eleicoes`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eleicoes`.`usuario` (
  `codigo_usuario` INT(11) NOT NULL AUTO_INCREMENT ,
  `matricula` VARCHAR(255) NOT NULL ,
  `nome` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`codigo_usuario`) )
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = latin1;



-- -----------------------------------------------------
-- Table `eleicoes`.`respostas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eleicoes`.`respostas` (
  `codigo_resposta` INT(11) NOT NULL AUTO_INCREMENT ,
  `codigo_usuario` INT(11) NOT NULL ,
  `codigo_questionario` INT(11) NOT NULL ,
  `codigo_questao` INT(11) NOT NULL ,
  `codigo_alternativa` INT(11) NOT NULL ,
  PRIMARY KEY (`codigo_resposta`) ,
  INDEX `FK8B2DBD723F154777` (`codigo_usuario` ASC) ,
  INDEX `FK8B2DBD72911BC697` (`codigo_questionario` ASC) ,
  INDEX `FK8B2DBD7210448863` (`codigo_questao` ASC) ,
  INDEX `FK8B2DBD72617E9515` (`codigo_alternativa` ASC) ,
  CONSTRAINT `FK8B2DBD7210448863`
    FOREIGN KEY (`codigo_questao` )
    REFERENCES `eleicoes`.`questoes` (`codigo_questao` )
    ON DELETE CASCADE,
  CONSTRAINT `FK8B2DBD723F154777`
    FOREIGN KEY (`codigo_usuario` )
    REFERENCES `eleicoes`.`usuario` (`codigo_usuario` )
    ON DELETE CASCADE,
  CONSTRAINT `FK8B2DBD72617E9515`
    FOREIGN KEY (`codigo_alternativa` )
    REFERENCES `eleicoes`.`alternativas` (`codigo_alternativa` )
    ON DELETE CASCADE,
  CONSTRAINT `FK8B2DBD72911BC697`
    FOREIGN KEY (`codigo_questionario` )
    REFERENCES `eleicoes`.`questionarios` (`codigo_questionario` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 64
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `eleicoes`.`usuario_questionario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `eleicoes`.`usuario_questionario` (
  `codigo_usuario_questionario` INT(11) NOT NULL AUTO_INCREMENT ,
  `codigo_usuario` INT(11) NOT NULL ,
  `codigo_questionario` INT(11) NOT NULL ,
  PRIMARY KEY (`codigo_usuario_questionario`) ,
  INDEX `FK5D0B3B6E3F154777` (`codigo_usuario` ASC) ,
  INDEX `FK5D0B3B6E911BC697` (`codigo_questionario` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- -----------------------------------------------------
-- Valores Default
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `eleicoes`.`administrador`
-- -----------------------------------------------------
INSERT INTO `eleicoes`.`administrador` (`login`, `senha`) VALUES ('administrador', 'eleicoes');

ALTER TABLE `eleicoes`.`usuario` ADD COLUMN `curso` VARCHAR(255) NOT NULL  AFTER `nome` ;

