CREATE TABLE `course`
(
    `course_id`  int(10) unsigned NOT NULL,
    `course_name`      varchar(45)      NOT NULL,
    `units`     varchar(45) DEFAULT NULL,
    `course_subject`     varchar(45) DEFAULT NULL,
    PRIMARY KEY (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;