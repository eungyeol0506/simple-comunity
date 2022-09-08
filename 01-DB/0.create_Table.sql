
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema simple-community
-- -----------------------------------------------------
-- show databases;
-- show tables;
-- use `simple-community`;
drop database IF EXISTS `simple-community`;

-- -----------------------------------------------------
-- Schema simple-community
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `simple-community` DEFAULT CHARACTER SET utf8 ;
USE `simple-community` ;

-- -----------------------------------------------------
-- Table `simple-community`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple-community`.`user` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `id` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `regist_date` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `update_date` TIMESTAMP NULL DEFAULT NULL,
  `delete_date` TIMESTAMP NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple-community`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple-community`.`board` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `contents` TEXT NOT NULL,
  `create_date` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `update_date` TIMESTAMP NULL DEFAULT NULL,
  `delete_date` TIMESTAMP NULL DEFAULT NULL,
  `topic` VARCHAR(50) NOT NULL,
  `user_no` INT NOT NULL,
  PRIMARY KEY (`no`),
  INDEX `fk_board_user_idx` (`user_no` ASC) VISIBLE,
  CONSTRAINT `fk_board_user`
    FOREIGN KEY (`user_no`)
    REFERENCES `simple-community`.`user` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple-community`.`attach`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple-community`.`attach` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `fileName` VARCHAR(45) NOT NULL,
  `size` INT NOT NULL,
  `board_no` INT NOT NULL,
  PRIMARY KEY (`no`),
  INDEX `fk_attach_board1_idx` (`board_no` ASC) VISIBLE,
  CONSTRAINT `fk_attach_board1`
    FOREIGN KEY (`board_no`)
    REFERENCES `simple-community`.`board` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple-community`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple-community`.`comment` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `contents` TEXT NOT NULL,
  `create_date` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `update_date` TIMESTAMP NULL DEFAULT NULL,
  `delete_date` TIMESTAMP NULL DEFAULT NULL,
  `board_no` INT NOT NULL,
  `user_no` INT NOT NULL COMMENT 'writer\n',
  PRIMARY KEY (`no`),
  INDEX `fk_comment_board1_idx` (`board_no` ASC) VISIBLE,
  INDEX `fk_comment_user1_idx` (`user_no` ASC) VISIBLE,
  CONSTRAINT `fk_comment_board1`
    FOREIGN KEY (`board_no`)
    REFERENCES `simple-community`.`board` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_no`)
    REFERENCES `simple-community`.`user` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------
-- Create example data
-- -----------------------------------------------------
insert into `simple-community`.`user`(`no`,`name`,`id`,`password`,`email`) values(1,'null유저','00000','@#nasd!@7@','0zero0@gmaiil.com');
insert into `simple-community`.`user`(`no`,`name`,`id`,`password`,`email`) values(2,'-----','tester','tester','tester@naveer.com');
insert into `simple-community`.`user`(`no`,`name`,`id`,`password`,`email`) values(3,'a1234','id1','pw1','a1234@daumn.net');

insert into `simple-community`.`board`(`no`,`title`,`contents`,`topic`,`user_no`) values(1,'title1','contents1','daily',3);
insert into `simple-community`.`board`(`no`,`title`,`contents`,`topic`,`user_no`) values(2,'title2','contents2','daily',3);
insert into `simple-community`.`board`(`no`,`title`,`contents`,`topic`,`user_no`) values(3,'title3','contents3','daily',3);
insert into `simple-community`.`board`(`no`,`title`,`contents`,`topic`,`user_no`) values(4,'title4','contents4','daily',3);
insert into `simple-community`.`board`(`no`,`title`,`contents`,`topic`,`user_no`) values(5, 'title5','attach here','daily',1);

insert into `simple-community`.`attach`(`no`,`fileName`,`size`,`board_no`) values(1,'test.TXT',17,5);

insert into `simple-community`.`comment`(`no`,`contents`,`board_no`,`user_no`) values(1,'첫번째댓글임','1','2');

select * from `simple-community`.`user`;