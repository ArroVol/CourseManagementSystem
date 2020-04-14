CREATE TABLE `instructor`
(
    `instructor_id`  int(10) unsigned NOT NULL ,
    `instructor_first_name`      varchar(45)      NOT NULL,
    `instructor_last_name`     varchar(45) NOT NULL,
    `instructor_middle_name`     varchar(45) DEFAULT NULL,
    `instructor_email`        varchar(45)      NOT NULL,
    PRIMARY KEY (`instructor_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;