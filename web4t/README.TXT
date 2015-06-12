[9단계: 트랜잭션 다루기]
1. 게시글의 변경 내역을 저장할 테이블을 생성한다.
create table board_log (
  blno INT NOT NULL,
  ip VARCHAR(20) NOT NULL,
  up_date DATETIME NOT NULL 
);

ALTER TABLE board_log
  ADD CONSTRAINT board_log_pk PRIMARY KEY(blno);

ALTER TABLE board_log
  MODIFY COLUMN blno INT NOT NULL AUTO_INCREMENT;  
  
  
  

