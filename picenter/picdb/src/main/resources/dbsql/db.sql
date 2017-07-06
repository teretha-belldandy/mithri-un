create database if not exists picenterdb;

use picenterdb;

CREATE TABLE `picuser` (
  `uid` int(20) NOT NULL,
  `uname` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `vip` tinyint(1) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `picinfo` (
  `pid` int(100) NOT NULL,
  `pname` varchar(255) NOT NULL,
  `pdesc` varchar(255) NOT NULL,
  `psize` double(100,0) NOT NULL,
  `ppath` varchar(255) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;