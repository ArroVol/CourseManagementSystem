CREATE TABLE IF NOT EXISTS `lab5`.`address` (
`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
`street` VARCHAR(45) NULL DEFAULT NULL,
`city` VARCHAR(45) NOT NULL,
`state` VARCHAR(20) NOT NULL,
`postal_code` VARCHAR(45) NOT NULL,
`student_id` INT UNSIGNED NOT NULL,
PRIMARY KEY (`id`),
INDEX `address_student_id_fk_idx` (`student_id` ASC) VISIBLE,
UNIQUE INDEX `student_id_UNIQUE` (`student_id` ASC) VISIBLE,
CONSTRAINT `address_student_id_fk`
    FOREIGN KEY (`student_id`)
        REFERENCES `lab5`.`student` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 15
    DEFAULT CHARACTER SET = utf8
