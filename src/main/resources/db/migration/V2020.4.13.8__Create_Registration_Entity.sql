CREATE TABLE `registration`
(
    `registration_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `student_id` INT UNSIGNED NOT NULL,
    `section_no` INT UNSIGNED NOT NULL,
    `semester` VARCHAR(45) NOT NULL,
    `course_name` VARCHAR(45) NOT NULL,
    `date_of_registration` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    `date_of_completion` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`registration_id`),
    INDEX `fk_student_id_idx` (`student_id` ASC) VISIBLE,
    INDEX `fk_section_no_idx` (`section_no` ASC) VISIBLE,
    UNIQUE INDEX `course_name_UNIQUE` (`course_name` ASC) VISIBLE,
    CONSTRAINT `fk_registration_student_id`
        FOREIGN KEY (`student_id`)
            REFERENCES `lab5`.`student` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_section_no`
        FOREIGN KEY (`section_no`)
            REFERENCES `lab5`.`section` (`section_no`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_course_name`
        FOREIGN KEY (`course_name`)
            REFERENCES `lab5`.`course` (`course_name`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;
