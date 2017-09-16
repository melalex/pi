CREATE SCHEMA `hospital`
  DEFAULT CHARACTER SET utf8;

USE hospital;

CREATE TABLE `hospital`.`application_user` (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(60) NOT NULL,

  PRIMARY KEY (`username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC)
);

CREATE TABLE `hospital`.`doctor` (
  `application_user` VARCHAR(60) NOT NULL,
  `first_name`       VARCHAR(60) NOT NULL,
  `last_name`        VARCHAR(60) NOT NULL,
  `secession`        VARCHAR(60) NOT NULL,

  PRIMARY KEY (`application_user`),
  FOREIGN KEY (`application_user`) REFERENCES `application_user` (`username`),
  UNIQUE INDEX `application_user_UNIQUE` (`application_user` ASC)
);

CREATE TABLE `hospital`.`duty` (
  `id`     INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `doctor` VARCHAR(60)  NOT NULL,
  `date`   DATE         NOT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (`doctor`) REFERENCES `doctor` (`application_user`),
  UNIQUE INDEX `id` (`id` ASC)
);

CREATE TABLE `hospital`.`patient` (
  `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name`  VARCHAR(60)  NOT NULL,
  `last_name`   VARCHAR(60)  NOT NULL,
  `description` TEXT,
  `doctor`      VARCHAR(60)  NOT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (`doctor`) REFERENCES `doctor` (`application_user`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
);