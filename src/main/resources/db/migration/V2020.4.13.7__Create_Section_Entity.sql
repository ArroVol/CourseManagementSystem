CREATE TABLE IF NOT EXISTS `lab5`.`section` (
    `section_no` INT UNSIGNED NOT NULL,
    `semester` VARCHAR(45) NOT NULL,
    `status` TINYINT NULL DEFAULT NULL,
    `room_no` VARCHAR(45) NULL DEFAULT NULL,
    `day_and_time` VARCHAR(45) NULL DEFAULT NULL,
    `course_id` INT UNSIGNED NOT NULL,
    `course_name` VARCHAR(45) NULL,
    `course_subject` VARCHAR(45) NULL,
    PRIMARY KEY (`section_no`),
    INDEX `fk_course_id_idx` (`course_id` ASC) VISIBLE,
    CONSTRAINT `fk_section_course_id`
        FOREIGN KEY (`course_id`)
            REFERENCES `lab5`.`course` (`course_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
