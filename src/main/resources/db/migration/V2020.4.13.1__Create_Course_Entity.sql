CREATE TABLE IF NOT EXISTS `lab5`.`course`
(
    `course_id` INT UNSIGNED NOT NULL,
    `course_name` VARCHAR(45) NOT NULL,
    `units` VARCHAR(45) NULL DEFAULT NULL,
    `course_subject` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`course_id`),
    UNIQUE INDEX `course_name_UNIQUE` (`course_name` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;
