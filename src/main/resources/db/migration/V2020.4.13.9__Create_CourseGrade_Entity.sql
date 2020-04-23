CREATE TABLE IF NOT EXISTS `lab5`.`course_grade` (
 `course_grade_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
 `student_id` INT UNSIGNED NOT NULL,
 `grade_received` VARCHAR(45) NOT NULL,
 `section_no` INT UNSIGNED NOT NULL,
 PRIMARY KEY (`course_grade_id`),
 INDEX `fk_student_id_idx` (`student_id` ASC) VISIBLE,
 INDEX `fk_section_no_idx` (`section_no` ASC) VISIBLE,
 CONSTRAINT `fk_student_id`
     FOREIGN KEY (`student_id`)
         REFERENCES `lab5`.`student` (`id`),
 CONSTRAINT `fk_course_grade_section_no`
     FOREIGN KEY (`section_no`)
         REFERENCES `lab5`.`section` (`section_no`)
         ON DELETE NO ACTION
         ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
