CREATE TABLE `section`
(
    `section_no`  int(10) unsigned NOT NULL ,
    `semester`      varchar(45)      NOT NULL,
    `course_id`     varchar(45) DEFAULT NULL,
    `instructor_id `     varchar(45) DEFAULT NULL,
    `status`        tinyint(4)      NOT NULL,
    `room_no`       varchar(2)       NOT NULL,
    `day_and_time `     varchar(45) DEFAULT NULL,

    PRIMARY KEY (`section_no`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;