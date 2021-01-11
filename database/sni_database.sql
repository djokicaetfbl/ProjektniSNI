#drop schema sni_database;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sni_database
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sni_database` DEFAULT CHARACTER SET utf8 ;
USE `sni_database` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sni_database`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `roles` VARCHAR(45) NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sni_database`.`article` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` INT NULL,
  `active` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into user values (0,'admin','C7AD44CBAD762A5DA0A452F9E854FDC1E0E7A52A38015F23F3EAB1D80B931DD472634DFAC71CD34EBC35D16AB7FB8A90C81F975113D6C7538DC69DD8DE9077EC','ADMIN',1);
insert into user values (0,'adminlw','AC88FA4880E752885ECFE5251A4A8E16F8C525A3BEAC9A3BC57CA61DB983E4126C72E906AEDE6A2ED0D72FDE22C7DEC4F4F41F1315F00C036124A5E5742510F3','ADMINLW',1);
insert into user values (0,'usershop','297EC9EEF739CF0391571F33987712935B49AAB30C62BBE8F5C9E493460BBE0422B5457101059194A1402029744B17BB349BCC4E1DEFBD0C5A1C04B1AD5DC1B0','USERSHOP',1);

insert into article values (0,'Mobile phone','100',1);
insert into article values (0,'Car','200',1);
insert into article values (0,'House','2000',1);
insert into article values (0,'Airplane','1000',1);
insert into article values (0,'Ship','800',1);


select * from user;
select * from article;
select * from chart;
select * from users;