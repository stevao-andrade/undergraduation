SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `egresso` DEFAULT CHARACTER SET latin1 ;
USE `egresso` ;

-- -----------------------------------------------------
-- Table `egresso`.`administrador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`administrador` (
  `codigo_administrador` INT(11) NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(255) NOT NULL ,
  `senha` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`codigo_administrador`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`questionarios`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`questionarios` (
  `codigo_questionario` INT(11) NOT NULL AUTO_INCREMENT ,
  `dataCriacao` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `nomeQuestionario` VARCHAR(255) NOT NULL ,
  `dataDisponibilidadeFinal` DATE NOT NULL ,
  PRIMARY KEY (`codigo_questionario`) )
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`questoes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`questoes` (
  `codigo_questao` INT(11) NOT NULL AUTO_INCREMENT ,
  `enunciadoQuestao` VARCHAR(255) NOT NULL ,
  `codigo_questionario` INT(11) NOT NULL ,
  PRIMARY KEY (`codigo_questao`) ,
  INDEX `FKBA82513B911BC697` (`codigo_questionario` ASC) ,
  CONSTRAINT `FKBA82513B911BC697`
    FOREIGN KEY (`codigo_questionario` )
    REFERENCES `egresso`.`questionarios` (`codigo_questionario` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`alternativas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`alternativas` (
  `codigo_alternativa` INT(11) NOT NULL AUTO_INCREMENT ,
  `enunciadoAlternativa` VARCHAR(255) NOT NULL ,
  `codigo_questao` INT(11) NOT NULL ,
  `codigo_questionario` INT(11) NOT NULL ,
  PRIMARY KEY (`codigo_alternativa`) ,
  INDEX `FK945FCDEA911BC697` (`codigo_questionario` ASC) ,
  INDEX `FK945FCDEA10448863` (`codigo_questao` ASC) ,
  CONSTRAINT `FK945FCDEA10448863`
    FOREIGN KEY (`codigo_questao` )
    REFERENCES `egresso`.`questoes` (`codigo_questao` )
    ON DELETE CASCADE,
  CONSTRAINT `FK945FCDEA911BC697`
    FOREIGN KEY (`codigo_questionario` )
    REFERENCES `egresso`.`questionarios` (`codigo_questionario` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 77
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`cursos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`cursos` (
  `codigo_curso` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`codigo_curso`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`usuario` (
  `codigo_usuario` INT(11) NOT NULL AUTO_INCREMENT ,
  `celular` VARCHAR(255) NOT NULL ,
  `cpf` VARCHAR(255),
  `email` VARCHAR(255) NOT NULL ,
  `matricula` VARCHAR(255) NOT NULL ,
  `nascimento` DATE NOT NULL ,
  `nome` VARCHAR(255) NOT NULL ,
  `rg` VARCHAR(255),
  `senha` VARCHAR(255) NOT NULL ,
  `sexo` VARCHAR(255) NOT NULL ,
  `telefone` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`codigo_usuario`) )
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`experienciaprofissional`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`experienciaprofissional` (
  `codigo_experiencia` INT(11) NOT NULL AUTO_INCREMENT ,
  `codigo_usuario` INT(11) NOT NULL ,
  `empresa` VARCHAR(255) NOT NULL ,
  `dataInicio` DATE NOT NULL ,
  `dataFim` DATE NOT NULL ,
  `cargo` VARCHAR(255) NOT NULL ,
  `areaFormacao` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`codigo_experiencia`, `codigo_usuario`) ,
  INDEX `FKD05D05F63F154777` (`codigo_usuario` ASC) ,
  CONSTRAINT `FKD05D05F63F154777`
    FOREIGN KEY (`codigo_usuario` )
    REFERENCES `egresso`.`usuario` (`codigo_usuario` )
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`faculdade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`faculdade` (
  `codigo_faculdade` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`codigo_faculdade`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`formacaoprofissional`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`formacaoprofissional` (
  `codigo_formacao` INT(11) NOT NULL AUTO_INCREMENT ,
  `codigo_usuario` INT(11) NOT NULL ,
  `dataFim` DATE NOT NULL ,
  `dataInicio` DATE NOT NULL ,
  `descricao` VARCHAR(500) NOT NULL ,
  `instituicaoFormacao` VARCHAR(255) NOT NULL ,
  `titulacao` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`codigo_formacao`, `codigo_usuario`) ,
  INDEX `FK79DC3E773F154777` (`codigo_usuario` ASC) ,
  INDEX `FK6E170A573F154777` (`codigo_usuario` ASC) ,
  CONSTRAINT `codigo_usuario`
    FOREIGN KEY (`codigo_usuario` )
    REFERENCES `egresso`.`usuario` (`codigo_usuario` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `FK6E170A573F154777`
    FOREIGN KEY (`codigo_usuario` )
    REFERENCES `egresso`.`usuario` (`codigo_usuario` )
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`instituicao_ensino`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`instituicao_ensino` (
  `codigo_instituicao` INT(11) NOT NULL AUTO_INCREMENT ,
  `curso` VARCHAR(255) NOT NULL ,
  `data_final` DATE NOT NULL ,
  `data_inicio` DATE NOT NULL ,
  `nome_instituicao` VARCHAR(255) NOT NULL ,
  `codigo_usuario` INT(11) NOT NULL ,
  PRIMARY KEY (`codigo_instituicao`) ,
  INDEX `FKA71F2CF33F154777` (`codigo_usuario` ASC) ,
  CONSTRAINT `FKA71F2CF33F154777`
    FOREIGN KEY (`codigo_usuario` )
    REFERENCES `egresso`.`usuario` (`codigo_usuario` )
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`respostas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`respostas` (
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
    REFERENCES `egresso`.`questoes` (`codigo_questao` )
    ON DELETE CASCADE,
  CONSTRAINT `FK8B2DBD723F154777`
    FOREIGN KEY (`codigo_usuario` )
    REFERENCES `egresso`.`usuario` (`codigo_usuario` )
    ON DELETE CASCADE,
  CONSTRAINT `FK8B2DBD72617E9515`
    FOREIGN KEY (`codigo_alternativa` )
    REFERENCES `egresso`.`alternativas` (`codigo_alternativa` )
    ON DELETE CASCADE,
  CONSTRAINT `FK8B2DBD72911BC697`
    FOREIGN KEY (`codigo_questionario` )
    REFERENCES `egresso`.`questionarios` (`codigo_questionario` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 64
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `egresso`.`usuario_questionario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `egresso`.`usuario_questionario` (
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
-- Table `egresso`.`administrador`
-- -----------------------------------------------------
INSERT INTO `egresso`.`administrador` (`login`, `senha`) VALUES ('administrador', 'egresso');


-- -----------------------------------------------------
-- Table `egresso`.`faculdade`
-- -----------------------------------------------------
INSERT INTO `egresso`.`faculdade` (`nome`) VALUES ('Faculdade Integral Diferencial');


-- -----------------------------------------------------
-- Table `egresso`.`cursos`
-- -----------------------------------------------------
INSERT INTO `egresso`.`cursos` (`nome`) VALUES ('Medicina');
INSERT INTO `egresso`.`cursos` (`nome`) VALUES ('Enfermagem');
INSERT INTO `egresso`.`cursos` (`nome`) VALUES ('Odontologia');
INSERT INTO `egresso`.`cursos` (`nome`) VALUES ('Fisioterapia');
INSERT INTO `egresso`.`cursos` (`nome`) VALUES ('Psicologia');
INSERT INTO `egresso`.`cursos` (`nome`) VALUES ('Farmácia');
INSERT INTO `egresso`.`cursos` (`nome`) VALUES ('Direito');
INSERT INTO `egresso`.`cursos` (`nome`) VALUES ('Sistemas_de_Informacao');