CREATE TABLE `section`
(
    `section_no` INT UNSIGNED NOT NULL,
    `semester` VARCHAR(45) NOT NULL,
    `instructor_id` INT UNSIGNED NOT NULL,
    `status` TINYINT NULL DEFAULT NULL,
    `room_no` VARCHAR(2) NULL DEFAULT NULL,
    `day_and_time` VARCHAR(45) NULL DEFAULT NULL,
    `course_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`section_no`),
    INDEX `fk_course_id_idx` (`course_id` ASC) VISIBLE,
    INDEX `fk_instructor_id_idx` (`instructor_id` ASC) VISIBLE,
    CONSTRAINT `fk_section_course_id`
        FOREIGN KEY (`course_id`)
            REFERENCES `lab5`.`course` (`course_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_instructor_id`
        FOREIGN KEY (`instructor_id`)
            REFERENCES `lab5`.`instructor` (`instructor_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;
