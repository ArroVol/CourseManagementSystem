CREATE TABLE IF NOT EXISTS `lab5`.`instructor_has_section` (
   `instructor_has_section_id` INT NOT NULL AUTO_INCREMENT,
   `instructor_instructor_id` INT UNSIGNED NOT NULL,
   `section_section_no` INT UNSIGNED NOT NULL,
   PRIMARY KEY (`instructor_has_section_id`),
   INDEX `fk_instructor_has_section_section_no_idx` (`section_section_no` ASC) VISIBLE,
   INDEX `fk_instructor_has_section_instructor_id_idx` (`instructor_instructor_id` ASC) VISIBLE,
   CONSTRAINT `fk_instructor_has_section_section_no`
       FOREIGN KEY (`section_section_no`)
           REFERENCES `lab5`.`section` (`section_no`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION,
   CONSTRAINT `fk_instructor_has_section_instructor_id`
       FOREIGN KEY (`instructor_instructor_id`)
           REFERENCES `lab5`.`instructor` (`instructor_id`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
