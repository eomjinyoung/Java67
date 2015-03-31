/* 컬럼의 값을 자동 증가시키기.
 * => 컬럼의 값을 입력하지 않아도 이전 값 보다 하나 증가된 값을 갖게 만든다. 
 * => AUTO_INCREMENT 명령
 * 
 */
CREATE TABLE board2 (
  bno       INT NOT NULL,
  title     VARCHAR(255) NOT NULL,
  content   TEXT NOT NULL,
  cre_date  DATETIME NOT NULL,
  views     INT DEFAULT 0,
  pwd       VARCHAR(20)
);

-- board2의 bno 컬럼을 primary key로 선언한다.
ALTER TABLE board2
  ADD CONSTRAINT board2_pk PRIMARY KEY(bno);

-- bno 컬럼에 AUTO_INCREMENT 속성을 추가한다.
-- AUTO_INCREMENT 속성은 KEY 컬럼에 대해서만 적용할 수 있다.
-- 그러므로 bno 컬럼을 먼저 primary key로 만든 다음, 이 속성을 지정해야 한다.
ALTER TABLE board2
  MODIFY COLUMN bno INT NOT NULL AUTO_INCREMENT;
 
-- 데이터 입력하기
INSERT INTO board2(title, content, cre_date)
VALUES('AAAAA', 'BBBBB', NOW());

INSERT INTO board2(title, content, cre_date)
VALUES('BBBBB', 'BBBBB', NOW());

INSERT INTO board2(title, content, cre_date)
VALUES('CCCCC', 'BBBBB', NOW());
  
/* 다른 테이블의 값을 입력하기
 * => 컬럼의 형식만 맞다면, 값을 넣을 수 있다면, 다른 테이블의 값을 입력할 수 있다.
 *  
 */
INSERT INTO board2(title, content, cre_date)
SELECT title, content, cre_date FROM board;  

/* sub-query?
 * => 질의문 안에서 존재하는 질의문.
 * => inner 클래스와 유사.
 * => 위의 질의문에서 insert 문 안에 select 문이 있다. 
 *    바로 select문을 서브쿼리라고 부른다.
 * => 서브쿼리는 어디에서든 사용할 수 있다.
 * 예)
 * select (서브쿼리), 컬럼, ... from 테이블명;
 * select 컬럼명, 컬럼명, ... from (서브쿼리);
 * select 컬럼명, 컬럼명, ... from 테이블명 where 컬럼 = (서브쿼리);
 */  
  














  
  
  