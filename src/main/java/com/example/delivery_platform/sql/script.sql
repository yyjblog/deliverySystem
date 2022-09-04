create database if not exists testdb;
use testdb ;
create table if not exists `user_info`
(
`user_id`   int NOT NULL AUTO_INCREMENT COMMENT 'ID',
`user_name`   varchar(100)   NOT NULL COMMENT '用户姓名',
`user_password` varchar(100)  NOT NULL COMMENT '用户密码',
`user_account`    varchar(100) NOT NULL COMMENT '用户邮箱',
`user_faceimage` varchar(200) NOT NULL COMMENT '用户头像',
`user_role` varchar(100) NOT NULL COMMENT '用户身份',
PRIMARY KEY (`user_id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;
create table if not exists `merchant_info`
(
`merchant_name`   varchar(100)   NOT NULL COMMENT '商家姓名',
`merchant_account` varchar(100)  NOT NULL COMMENT '商家账号',
`merchant_shop`    varchar(100)  NOT NULL COMMENT '商家店铺',
PRIMARY KEY (`merchant_account`)
 )
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

