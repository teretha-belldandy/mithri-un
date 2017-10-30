create database if not exists picenterdb;

use picenterdb;

/*==============================================================*/
/* Table: picuser                                               */
/*==============================================================*/
drop table if exists picuser;

CREATE TABLE picuser (
  uid			bigint NOT NULL auto_increment comment '主键id',
  certi_no		varchar(32) NOT NULL comment '证件号',
  uname			varchar(20) NOT NULL comment '用户名',
  age			int(11) NOT NULL comment '年龄',
  vip			tinyint(1) DEFAULT NULL comment 'vip',
  gender		int(11) DEFAULT NULL comment '性别',
  create_by		char(32) DEFAULT '' comment '创建者',
  create_time	timestamp not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  modify_by		char(32) DEFAULT '' comment '修改者',
  modify_time	timestamp not null DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
  PRIMARY KEY (uid),
  UNIQUE KEY uk_picuser_certi_no (certi_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: picinfo                                               */
/*==============================================================*/
drop table if exists picinfo;

CREATE TABLE picinfo (
  pid			bigint NOT NULL auto_increment comment '主键id',
  pname			varchar(255) NOT NULL comment '名称',
  pdesc			varchar(255) NOT NULL comment '详情',
  psize			double(100,0) NOT NULL comment '大小',
  ppath			varchar(255) NOT NULL comment '路径',
  create_by		char(32) DEFAULT '' comment '创建者',
  create_time	timestamp not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  modify_by		char(32) DEFAULT '' comment '修改者',
  modify_time	timestamp not null DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
  PRIMARY KEY (pid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
