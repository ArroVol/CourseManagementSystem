CREATE TABLE IF NOT EXISTS `lab5`.`the_user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `student_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_user_student_id_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `lab5`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
