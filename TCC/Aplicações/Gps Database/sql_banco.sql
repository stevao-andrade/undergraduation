SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `gpsdb` DEFAULT CHARACTER SET latin1 ;
USE `gpsdb` ;

-- -----------------------------------------------------
-- Table `gpsdb`.`gps_info`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gpsdb`.`gps_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `numero_serie` BIGINT(20) NOT NULL ,
  `numero_autorizado` BIGINT(20) NOT NULL ,
  `horario` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `latitude` DOUBLE NOT NULL ,
  `longitude` DOUBLE NOT NULL ,
  `altitude` DOUBLE NOT NULL ,
  `velocidade` DOUBLE NOT NULL ,
  `imei` BIGINT(20) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gpsdb`.`gps_signal`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gpsdb`.`gps_signal` (
  `imei` BIGINT(20) NOT NULL ,
  `ultimo_envio` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  `label` VARCHAR(70) NULL DEFAULT NULL ,
  PRIMARY KEY (`imei`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
