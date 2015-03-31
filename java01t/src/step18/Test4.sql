/* MySQL의 컬럼 데이터 타입
 * => 표준 타입 + DBMS 고유 타입 => DBMS 매뉴얼을 참고해야 한다.
 * 
 * => 주요 타입
 * int, integer : 4byte 정수 값
 * decimal(m,d), numeric(m,d) : m자리 크기, d 소수점 
 * date : 날짜
 * time : 시간
 * datetime : 날짜 + 시간 
 * char(m) : 최대 m(255까지 지정 가능)자리 문자 저장. 고정 크기. 
 *           크기 보다 작은 문자를 저장해도 m 크기를 갖는다.
 * varchar(m) : 최대 m(255까지 지정 가능)자리 문자 저장. 가변 크기.
 *           저장한 문자열의 개수 만큼 크기를 갖는다. => 메모리 절약
 *           => 크기가 변하기 때문에 검색 속도가 느리다.  
 * text, blob : 최대 65535 문자를 저장할 수 있다. 가변 크기.
 * mediumblob, mediumtext : 2^24 문자 저장. 약 16M 크기의 문자 저장.
 * 
 * => 사진 파일이나 음악 파일과 같은 이진 데이터의 저장?
 *    => 가능한 파일을 DBMS에 저장하지 말아라. 외부 파일 시스템(HDD)에 저장한 후
 *       그 파일의 경로를 DBMS에서 관리하라!
 * 
 * reserved keyword : 시스템에서 명령어로 사용하기 위해 미리 등록한 이름.
 * 
 * 예: 게시판 테이블 만들기
 * 
 */
CREATE TABLE board(
  bno INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  cre_date DATETIME NOT NULL,
  views INT DEFAULT 0,
  pwd VARCHAR(20)
);

ALTER TABLE board
  ADD CONSTRAINT board_pk PRIMARY KEY (bno);

INSERT INTO board(bno, title, content, cre_date)
VALUES(1, 'AAAAAA', 'AAAAAAAA', NOW());

INSERT INTO board(bno, title, content, cre_date)
VALUES(2, 'bbbbbb', 'AAAAAAAA', NOW());

INSERT INTO board(bno, title, content, cre_date)
VALUES(3, 'cccccc', 'AAAAAAAA', NOW());

INSERT INTO board(bno, title, content, cre_date)
VALUES(4, 'dddddd', 'AAAAAAAA', NOW());


/* MySQL 서버에서 제공하는 함수
 * 
 * now() : 날짜 + 시간 
 */













