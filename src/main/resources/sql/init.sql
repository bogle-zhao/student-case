-- CREATE DATABASE test;
CREATE TABLE `student`
(
    `id`   bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` varchar(40) NULL COMMENT '名字',
    `age`  int          NOT NULL COMMENT '年龄',
    `sex`  int NULL COMMENT '性别，0:未知，1:男，2:女',
    `num`  varchar(255) NOT NULL COMMENT '学号',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uniq_num`(`num`)
);