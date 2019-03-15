CREATE DATABASE study CHARACTER SET utf8 COLLATE utf8_bin;
GRANT ALL PRIVILEGES ON study.* TO 'study'@'%' IDENTIFIED BY 'study!@#';
FLUSH PRIVILEGES;


DROP TABLE TB_NOTICE;

CREATE TABLE TB_NOTICE(
      NOTICE_SN              INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '일련번호'
    , NOTICE_TITLE           VARCHAR(255) NULL COMMENT '제목'
    , NOTICE_CONTENTS        MEDIUMTEXT NULL COMMENT '내용'
    , DELETE_YN              CHAR(1) NOT NULL COMMENT '삭제여부 Y, N'
    , REG_USER_SN            INT(11) NULL COMMENT '등록 회원 일련번호'
    , REG_DATETIME           DATETIME NULL COMMENT '등록일시'
    , REG_IP                 VARCHAR(255) NULL COMMENT '등록 IP'
    , MOD_USER_SN            INT(11) NULL COMMENT '수정 회원 일련번호'
    , MOD_DATETIME           DATETIME NULL COMMENT '수정일시'
    , MOD_IP                 VARCHAR(255) NULL COMMENT '수정 IP'
) COMMENT = '공지 게시판';


