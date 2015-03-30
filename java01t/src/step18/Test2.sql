/* 실습 목표: 테이블 생성
 * 
 * 데이터베이스(스키마) => 데이터를 저장하고 조회하는데 필요한 데이터 파일.
 *                    (예: 엑셀의 파일)
 * 테이블 => 데이터를 저장하기 위해 형식을 갖춘 틀. (예: 엑셀의 시트와 유사)
 * 
 * 1. 테이블 생성
 * CREATE TABLE 테이블명(
 *   컬럼명 타입 [NULL | NOT NULL] 옵션들... ,
 *   컬럼명 타입 [NULL | NOT NULL] 옵션들... ,
 *   컬럼명 타입 [NULL | NOT NULL] 옵션들... 
 * );
 * 
 * => 데이터베이스는 보통 대소문자를 구분하지 않는다.
 * => 테이블 이름이나 컬럼 이름을 지을 때 낙타 표기법을 사용하지 않는다.
 * => (낙타 표기법: firstName, countOfStudent, kilometerPerHour, ...) 
 * =>            fistname,  countofstudent, kilometerperhour, ...
 * => 그래서 테이블 이름이나 컬럼 이름을 "약어_약어_약어" 형식으로 짓는다.
 *    예: FST_NAM, KM_HR, CNT_STUD, ...
 *
 * 예1) 간단히 "test2" 테이블 생성
 */
CREATE TABLE test2 (
  tno INT NOT NULL,
  title VARCHAR(200) NOT NULL,
  writer VARCHAR(20)
);
   
/* 2. 테이블에 데이터 입력하기
 * INSERT INTO 테이블명(컬럼명, 컬럼명, ...) VALUES(값, 값, ...);
 * 
 * 예1)
 */ 
INSERT INTO test2(tno, title, writer) VALUES(1, 'aaaa', 'hong');
INSERT INTO test2(tno, title, writer) VALUES(2, 'bbbb', 'hong');
INSERT INTO test2(tno, title, writer) VALUES(3, 'cccc', 'hong');
 
/* 3. 데이터 조회하기
 * SELECT 컬럼명, 컬럼명, ... FROM 테이블명;
 * 
 * 예1)
 */
SELECT tno, title, writer FROM test2;


/* 4. 데이터 변경하기
 * UPDATE 테이블명 SET 컬럼명 = 변경할 값, 컬럼명 = 변경할 값, ... 
 * WHERE 컬럼명 = 조건 
 * 
 * 예1)
 */
UPDATE test2 SET writer = 'bbb@test.com' WHERE tno = 1;
UPDATE test2 SET writer = 'ccc@test.com' WHERE tno = 3;

/* 5. 데이터 삭제하기
 * DELETE FROM 테이블명 WHERE 컬럼명 = 조건;
 * 
 * 예1)
 */
DELETE FROM test2 WHERE tno = 2;

/* 6. 테이블 삭제하기
 * DROP TABLE 테이블명;
 * 
 * 예1)
 */
DROP TABLE test2;











