CREATE TABLE IF NOT EXISTS `lab5`.`instructor` (
`instructor_id` INT UNSIGNED NOT NULL,
  `instructor_first_name` VARCHAR(45) NOT NULL,
  `instructor_last_name` VARCHAR(45) NOT NULL,
  `instructor_middle_name` VARCHAR(45) NULL DEFAULT NULL,
  `instructor_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`instructor_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
