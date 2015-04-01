/* SELECT 문 사용
 * => 테이블의 데이터를 조회하는 명령. 
 */

-- 1) SELECT 컬럼명, 컬럼명, ... FROM 테이블명;
SELECT title, content
FROM board2;

-- 2) WHERE : 조회할 행에 대해 제한을 가함. 
-- 실행 순서: 
--  => board2 테이블을 선택한다. 
--  => WHERE 조건에 해당하는 행(레코드)을 결정한다.
--  => 결정된 행에서 SELECT에 지정된 컬럼 값을 꺼낸다.
SELECT title, content
FROM board2
WHERE bno > 3 AND bno < 7;

-- 3) DISTINCT / ALL
-- ALL: 모든 데이터를 출력하라.
-- 생략하면 ALL이 자동으로 붙는다.
SELECT ALL LOC, ROOM FROM CLASSROOMS;
SELECT ALL LOC FROM CLASSROOMS;
SELECT LOC FROM CLASSROOMS;

-- DISTINCT : 중복 제거
SELECT DISTINCT LOC FROM CLASSROOMS;

-- 4) ORDER BY : 출력할 데이터의 정렬 방식을 지정한다.
-- 예) ORDER BY 컬럼명 (ASC/DESC), 컬럼명 (ASC/DESC)
-- ASC : 오름차순으로 정렬 (A - Z)
-- DESC : 내림차순으로 정렬 (Z - A)
SELECT NAME, EMAIL
FROM TRAINERS
ORDER BY NAME ASC;

-- 정렬 방식을 생략하면 ASC로 취급한다.
SELECT NAME, EMAIL
FROM TRAINERS
ORDER BY NAME;

SELECT NAME, EMAIL
FROM TRAINERS
ORDER BY NAME DESC;

-- FROM(테이블 선택한다.) 
--  => WHERE(조건에 맞는 데이터를 고른다.) 
--  => ORDER BY(고른 데이터를 조건에 맞추어 정렬한다.) 
--  => SELECT(최종 결정된 데이터 중에서 특정 컬럼 값을 추출한다.) 절을 실행한다.
SELECT NAME, EMAIL
FROM TRAINERS
ORDER BY TEL DESC;

-- 오름차순(ascending)으로 정렬할 때 NULL 값은 앞에 놓인다. 
-- 내림차순(descending)으로 정렬할 때 NULL 값은 뒤에 놓인다.
SELECT TITLE, CNO
FROM LECTURES
ORDER BY CNO DESC;


-- 4) ALIAS(별명)
-- 컬럼 결과를 출력할 때 컬럼 이름 대신 별명을 줄 수 있다.
SELECT TITLE AS '강의명', CNO AS '교실번호'
FROM LECTURES;

-- AS는 생략할 수 있다.
SELECT TITLE '강의명', CNO '교실번호'
FROM LECTURES;

-- 따옴표 생략할 수 있다.
SELECT TITLE 강의명, CNO 교실번호
FROM LECTURES;

-- 별명에 공백을 포함하고 있다면, 따옴표로 감싸야 한다.
SELECT TITLE '강의 이름', CNO 교실번호
FROM LECTURES;

/*[WHERE 절] 
 * WHERE 절에 사용할 수 있는 연산자
 * => 산술 연산자: (), +, -, *, /
 * => 비교 연산자: =, <>, !=, <, >, <=, >= 등
 * => 논리 연산자: AND, OR, NOT
 * => SQL 연산자: IN, BETWEEN, IS NULL, LIKE 등 
 */

-- IS NULL 사용: 강의실이 배정되지 않은 강의를 모두 출력하라.
SELECT TITLE, CNO
FROM LECTURES
WHERE CNO IS NULL;

-- IS NOT NULL : 지정한 컬럼의 값이 NULL이 아닌 것을 고른다.
SELECT TITLE, CNO
FROM LECTURES
WHERE CNO IS NOT NULL;

-- '=' 연산자를 NULL 값을 갖는지 조사할 수 없다. 주의!
SELECT TITLE, CNO
FROM LECTURES
WHERE CNO = NULL;

-- LIKE 사용: 자바 강의만 모두 출력하라.
-- like '접두사%' : 해당 접두사로 시작하는 것을 모두 고른다. %는 0이상을 의미 
SELECT TITLE
FROM LECTURES
WHERE TITLE LIKE '[자바%';

-- like '%과정' : 0 개 이상의 문자가 앞에 있고, 맨 끝 문자는 '과정'으로 끝나는 것.
SELECT TITLE
FROM LECTURES
WHERE TITLE LIKE '%과정';

-- like '_길_' : 총 3개의 글자이고, 앞의 첫 글자는 아무거나 와도 된다.
--               단, 두 번째 글자는 '길'이어야 한다. 세 번째는 아무거나 와도 된다.
--        밑줄(_)은 글자 하나를 의미한다.
SELECT NAME
FROM TRAINERS
WHERE NAME LIKE '_길_';






















