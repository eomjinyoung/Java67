/* 1. Primary Key(주키)
 * => 테이블에 저장된 데이터(record, row)를 구분할 때 사용할 컬럼 집합
 * 
 * 실습1: primary key가 없으면, 데이터 중복을 막을 수가 없다.
 * => 준비: test2 테이블 생성 및 데이터 등록
 * => 새 데이터 입력: 번호가 중복되어도 오류가 발생하지 않는다.
 */
INSERT INTO test2(tno, title, writer) VALUES(3, 'ddd', 'hong');

/* 실습2: primary key가 없으면, 삭제할 때 레코드를 구분할 수 없다.
 * => 준비: 다음 새 데이터를 입력하라!
 */
INSERT INTO test2(tno, title, writer) VALUES(3, 'ddd', 'hong');
/* => 현재 "3,ddd,hong" 데이터가 두 개 등록되어 있다. 둘 중 하나를 삭제하라!
 */
DELETE FROM test2 WHERE tno = 3 AND title = 'ddd' AND writer = 'hong';
/* => 둘 중 하나만 지울 수가 없다. 둘 모두 삭제된다.
 * 
 * 실습1과 실습2의 문제점? primary key가 없기 때문에,
 * 모든 컬럼의 값이 동일할 때 특정 레코드만 지정하여 삭제할 수 없다.
 * 
 * 해결책: 테이블을 만들 때 반드시 primary key 컬럼을 지정하라!
 * 
 */

/* 2. Primary Key 지정하기
 * 방법1: 테이블 생성문에서 컬럼명 뒤에 primary key 명령을 추가한다.
 * 
 * CREATE TABLE 테이블명 (
 *   컬럼명 타입 PRIMARY KEY,
 *   컬럼명 타입,
 *   컬럼명 타입, 
 *   ...
 * );
 * 
 * 예)
 */
CREATE TABLE test3 (
  tno INT NOT NULL PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  writer VARCHAR(20)
);

/* 실습1: 데이터 중복 테스트!
 * 
 * 예) 
 * => 일단 기본 데이터 3개를 입력한다.
 */
INSERT INTO test3(tno, title, writer) VALUES(1, 'aaaa', 'hong');
INSERT INTO test3(tno, title, writer) VALUES(2, 'bbbb', 'hong');
INSERT INTO test3(tno, title, writer) VALUES(3, 'cccc', 'hong');

/* => tno 컬럼 값이 같은 데이터를 입력한다. => primary key 중복 오류 발생!
 */
INSERT INTO test3(tno, title, writer) VALUES(2, 'dddd', 'hong');

/* 실습2: 중복 데이터 삭제 테스트!
 * 예) title이 'cccc', writer가 'hong'인 데이터를 입력한다. 
 *    단 tno 값은 달라야 한다.
 */
INSERT INTO test3(tno, title, writer) VALUES(4, 'cccc', 'hong');
/* 예) 'cccc' 제목을 갖는 두 개의 중복 레코드 중에서 하나를 삭제해보자! 
 * => 이렇게 중복 레코드가 있으면, PK 컬럼으로 특정 레코드를 삭제할 수 있다.
 */ 
DELETE FROM test3 WHERE tno = 3;

/* 2. Primary Key 지정하기(계속)
 * 방법2: 테이블 생성한 후 테이블 변경문에서 primary key 지정한다.
 * 
 * ALTER TABLE 테이블명 
 *   ADD CONSTRAINT 제어명 PRIMARY KEY (컬럼명, 컬럼명, ...)
 * - 제어명: 이 제약 조건에 대한 라벨이다. symbol이라 한다.
 * 
 */
CREATE TABLE test4 (
  tno INT NOT NULL,
  title VARCHAR(200) NOT NULL,
  writer VARCHAR(20)
);

ALTER TABLE test4 
  ADD CONSTRAINT test4_pk PRIMARY KEY (tno);

INSERT INTO test4(tno, title, writer) VALUES(1, 'aaaa', 'hong');
INSERT INTO test4(tno, title, writer) VALUES(2, 'bbbb', 'hong');

/* 다음과 존재하는 tno 값으로 데이터를 입력하면 오류가 발생한다! 
 * PK가 정상적으로 지정되었음을 확인할 수 있다.
 */ 
INSERT INTO test4(tno, title, writer) VALUES(2, 'cccc', 'hong');

/* 2. Primary Key 지정하기(계속)
 * 방법3: 테이블 생성문 안에 제약조건을 기술한다.
 * 
 * CREATE TABLE 테이블 (
 *   컬럼명 타입,
 *   컬럼명 타입, 
 *   ...,
 *   CONSTRAINT 제어명 PRIMARY KEY (tno)
 * )
 */
CREATE TABLE test5 (
  tno INT NOT NULL,
  title VARCHAR(200) NOT NULL,
  writer VARCHAR(20),
  CONSTRAINT test5_pk PRIMARY KEY (tno)
);













