CREATE TABLE `registration`
(
    `registration_id`  int(10) unsigned NOT NULL AUTO_INCREMENT ,
    `student_id`  int(10) unsigned NOT NULL ,
    `section_no`      varchar(45)      NOT NULL,
    `semester`     varchar(45) NOT NULL,
    `course_name`     varchar(45) DEFAULT NULL,
    `date_of_registration`  datetime         DEFAULT CURRENT_TIMESTAMP,
    `date_of_completion`  datetime         DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (`registration_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;