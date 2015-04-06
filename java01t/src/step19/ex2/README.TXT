1. 실습 전에 준비해야 할 테이블
---------------------------------
CREATE TABLE USERS(
  UNO INT NOT NULL,
  NAME VARCHAR(50) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  TEL VARCHAR(20) NOT NULL,
  HP VARCHAR(255) NULL,
  TWIT VARCHAR(20) NULL
);

ALTER TABLE USERS
  ADD CONSTRAINT USERS_PK PRIMARY KEY (UNO);

ALTER TABLE USERS
  MODIFY COLUMN UNO INT NOT NULL AUTO_INCREMENT;

2. 실습 순서
1) 1단계: 메서드 당 1개의 Connection
   => MemberDao.01, MemberControl.01

2) 2단계: Dao 당 1개의 Connection
   => MemberDao.02, MemberControl.02
   
3) 3단계: DB 커넥션풀 도입
   => util/DBConnectionPool, MemberDao, MemberControl











  