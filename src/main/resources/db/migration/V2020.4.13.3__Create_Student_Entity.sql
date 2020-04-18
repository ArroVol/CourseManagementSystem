CREATE TABLE IF NOT EXISTS `lab5`.`student`
(
    `id` INT UNSIGNED NOT NULL,
    `student_first_name` VARCHAR(45) NOT NULL,
    `student_last_name` VARCHAR(45) NOT NULL,
    `student_middle_name` VARCHAR(45) NULL DEFAULT NULL,
    `ssn` VARCHAR(45) NOT NULL,
    `dob` VARCHAR(2) NOT NULL,
    `studentEmail` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;
