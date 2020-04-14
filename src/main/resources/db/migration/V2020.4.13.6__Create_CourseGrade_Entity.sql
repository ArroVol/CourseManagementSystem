CREATE TABLE `course_grade`
(
    `course_grade_id`  int(10) unsigned NOT NULL AUTO_INCREMENT ,
    `course_id`  int(10) unsigned NOT NULL ,
    `student_id`      varchar(45)      NOT NULL,
    `grade_received`     varchar(45) NOT NULL,
    PRIMARY KEY (`course_grade_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;