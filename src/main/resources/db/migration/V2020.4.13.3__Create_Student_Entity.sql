CREATE TABLE `student`
(
    `id`  int(10) unsigned NOT NULL AUTO_INCREMENT,
    `student_first_name`      varchar(45)      NOT NULL,
    `student_last_name`     varchar(45) NOT NULL,
    `student_middle_name`     varchar(45) DEFAULT NULL,
    `ssn`        varchar(45)      NOT NULL,
    `dob`       varchar(2)       NOT NULL,
    `studentEmail` varchar(45)      NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;