create database if not exists picenterdb;

use picenterdb;

/*==============================================================*/
/* Table: picuser                                               */
/*==============================================================*/
drop table if exists picuser;

CREATE TABLE picuser (
  uid			bigint NOT NULL auto_increment comment '����id',
  certi_no		varchar(32) NOT NULL comment '֤����',
  uname			varchar(20) NOT NULL comment '�û���',
  age			int(11) NOT NULL comment '����',
  vip			tinyint(1) DEFAULT NULL comment 'vip',
  gender		int(11) DEFAULT NULL comment '�Ա�',
  create_by		char(32) DEFAULT '' comment '������',
  create_time	timestamp not null DEFAULT CURRENT_TIMESTAMP comment '����ʱ��',
  modify_by		char(32) DEFAULT '' comment '�޸���',
  modify_time	timestamp not null DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '�޸�ʱ��',
  PRIMARY KEY (uid),
  UNIQUE KEY uk_picuser_certi_no (certi_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: picinfo                                               */
/*==============================================================*/
drop table if exists picinfo;

CREATE TABLE picinfo (
  pid			bigint NOT NULL auto_increment comment '����id',
  pname			varchar(255) NOT NULL comment '����',
  pdesc			varchar(255) NOT NULL comment '����',
  psize			double(100,0) NOT NULL comment '��С',
  ppath			varchar(255) NOT NULL comment '·��',
  create_by		char(32) DEFAULT '' comment '������',
  create_time	timestamp not null DEFAULT CURRENT_TIMESTAMP comment '����ʱ��',
  modify_by		char(32) DEFAULT '' comment '�޸���',
  modify_time	timestamp not null DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '�޸�ʱ��',
  PRIMARY KEY (pid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
