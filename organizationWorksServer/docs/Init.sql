-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sethomecompanydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sethomecompanydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sethomecompanydb` DEFAULT CHARACTER SET utf8 ;
USE `sethomecompanydb` ;

-- -----------------------------------------------------
-- Table `sethomecompanydb`.`about_company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sethomecompanydb`.`about_company` (
  `id_company` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `logo` LONGBLOB NOT NULL,
  `history` VARCHAR(512) NOT NULL,
  PRIMARY KEY (`id_company`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sethomecompanydb`.`office`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sethomecompanydb`.`office` (
  `id_office` INT(11) NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `zip_code` VARCHAR(45) NOT NULL,
  `address` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id_office`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sethomecompanydb`.`user_position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sethomecompanydb`.`user_position` (
  `id_user_position` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id_user_position`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sethomecompanydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sethomecompanydb`.`user` (
  `id_person` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(128) NOT NULL,
  `last_name` VARCHAR(128) NOT NULL,
  `middle_name` VARCHAR(128) NOT NULL,
  `user_position_id_user_position` INT(11) NOT NULL,
  `description` VARCHAR(512) NULL DEFAULT NULL,
  `image` LONGBLOB NULL DEFAULT NULL,
  `office_id_office` INT(11) NOT NULL,
  PRIMARY KEY (`id_person`),
  INDEX `fk_user_user_position1_idx` (`user_position_id_user_position` ASC),
  INDEX `fk_user_office1_idx` (`office_id_office` ASC),
  CONSTRAINT `fk_user_office1`
    FOREIGN KEY (`office_id_office`)
    REFERENCES `sethomecompanydb`.`office` (`id_office`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_user_position1`
    FOREIGN KEY (`user_position_id_user_position`)
    REFERENCES `sethomecompanydb`.`user_position` (`id_user_position`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sethomecompanydb`.`career`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sethomecompanydb`.`career` (
  `id_career` INT(11) NOT NULL AUTO_INCREMENT,
  `user_position_id_user_position` INT(11) NOT NULL,
  `description` VARCHAR(512) NOT NULL,
  `requirements` VARCHAR(512) NOT NULL,
  `user_id_person` INT(11) NOT NULL,
  `office_id_office` INT(11) NOT NULL,
  PRIMARY KEY (`id_career`),
  INDEX `fk_career_user_position1_idx` (`user_position_id_user_position` ASC),
  INDEX `fk_career_user1_idx` (`user_id_person` ASC),
  INDEX `fk_career_office1_idx` (`office_id_office` ASC),
  CONSTRAINT `fk_career_office1`
    FOREIGN KEY (`office_id_office`)
    REFERENCES `sethomecompanydb`.`office` (`id_office`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_career_user1`
    FOREIGN KEY (`user_id_person`)
    REFERENCES `sethomecompanydb`.`user` (`id_person`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_career_user_position1`
    FOREIGN KEY (`user_position_id_user_position`)
    REFERENCES `sethomecompanydb`.`user_position` (`id_user_position`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sethomecompanydb`.`email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sethomecompanydb`.`email` (
  `id_email` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(128) NOT NULL,
  `user_id_person` INT(11) NOT NULL,
  PRIMARY KEY (`id_email`),
  INDEX `fk_email_user1_idx` (`user_id_person` ASC),
  CONSTRAINT `fk_email_user1`
    FOREIGN KEY (`user_id_person`)
    REFERENCES `sethomecompanydb`.`user` (`id_person`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sethomecompanydb`.`phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sethomecompanydb`.`phone` (
  `id_phone` INT(11) NOT NULL AUTO_INCREMENT,
  `phone` VARCHAR(128) NOT NULL,
  `user_id_person` INT(11) NOT NULL,
  PRIMARY KEY (`id_phone`),
  INDEX `fk_phone_user_idx` (`user_id_person` ASC),
  CONSTRAINT `fk_phone_user`
    FOREIGN KEY (`user_id_person`)
    REFERENCES `sethomecompanydb`.`user` (`id_person`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sethomecompanydb`.`portfolio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sethomecompanydb`.`portfolio` (
  `id_project` INT(11) NOT NULL AUTO_INCREMENT,
  `link` VARCHAR(128) NULL DEFAULT NULL,
  `description` VARCHAR(512) NOT NULL,
  `screenshot` LONGBLOB NOT NULL,
  PRIMARY KEY (`id_project`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sethomecompanydb`.`user_credentials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sethomecompanydb`.`user_credentials` (
  `id_user_credentials` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `user_id_person` INT(11) NOT NULL,
  PRIMARY KEY (`id_user_credentials`),
  INDEX `fk_user_credentials_user1_idx` (`user_id_person` ASC),
  CONSTRAINT `fk_user_credentials_user1`
    FOREIGN KEY (`user_id_person`)
    REFERENCES `sethomecompanydb`.`user` (`id_person`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
