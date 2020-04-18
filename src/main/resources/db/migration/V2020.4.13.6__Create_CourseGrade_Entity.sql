CREATE TABLE IF NOT EXISTS `lab5`.`course_grade`
(
`course_grade_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `course_id` INT UNSIGNED NOT NULL,
  `student_id` INT UNSIGNED NOT NULL,
  `grade_received` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`course_grade_id`),
  INDEX `fk_course_id_idx` (`course_id` ASC) VISIBLE,
  INDEX `fk_student_id_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_id`
    FOREIGN KEY (`course_id`)
    REFERENCES `lab5`.`course` (`course_id`)
    ON DELETE CASCADE
       ON UPDATE CASCADE,
              CONSTRAINT `fk_student_id`
              FOREIGN KEY (`student_id`)
              REFERENCES `lab5`.`student` (`id`)
          ON DELETE NO ACTION
             ON UPDATE NO ACTION)
                    ENGINE = InnoDB
                    DEFAULT CHARACTER SET = utf8;
