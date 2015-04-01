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

-- 날짜 다루기
SELECT TITLE, ST_DATE, ED_DATE
FROM LECTURES;


SELECT TITLE, ST_DATE, ED_DATE
FROM LECTURES
WHERE ST_DATE = '2015-01-02';

-- 0을 생략해도 된다.
SELECT TITLE, ST_DATE, ED_DATE
FROM LECTURES
WHERE ST_DATE = '2015-1-2';


-- BETWEEN A AND B
SELECT TITLE, ST_DATE, ED_DATE
FROM LECTURES
WHERE ST_DATE BETWEEN '2015-2-1' AND '2015-3-15';

SELECT TITLE, ST_DATE, ED_DATE
FROM LECTURES
WHERE ST_DATE >= '2015-2-1' AND ST_DATE <= '2015-3-15';

-- IN : 자바, C, C++ 중 하나 이상을 강의하는 강사를 찾아라.
SELECT TNO
FROM SUB_TRAI
WHERE SNO = 1 || SNO = 2 || SNO = 3;

-- 오라클에서 || 연산자는 문자열을 연결하는 일을 한다.
-- 가능한 OR 를 사용하라!
SELECT TNO
FROM SUB_TRAI
WHERE SNO = 1 OR SNO = 2 OR SNO = 3;

SELECT DISTINCT TNO
FROM SUB_TRAI
WHERE SNO = 1 OR SNO = 2 OR SNO = 3;


SELECT DISTINCT TNO
FROM SUB_TRAI
WHERE SNO IN (1, 2, 3);

-- 서브쿼리를 이용한 강사 이름 출력하기
SELECT DISTINCT (SELECT NAME FROM TRAINERS T2 WHERE T2.TNO = T1.TNO)
FROM SUB_TRAI T1
WHERE SNO IN (1, 2, 3);

-- 출력하는 값의 컬럼 제목이 너무 길다. => 줄인다 => 별명 사용!
SELECT DISTINCT (SELECT NAME 
                 FROM TRAINERS T2 
                 WHERE T2.TNO = T1.TNO) AS '강사명'
FROM SUB_TRAI T1
WHERE SNO IN (1, 2, 3);


-- 과목의 번호를 직접 기입하는 방식은 코드 해석을 어렵게 한다.
SELECT DISTINCT (SELECT NAME 
                 FROM TRAINERS T2 
                 WHERE T2.TNO = T1.TNO) AS '강사명'
FROM SUB_TRAI T1
WHERE SNO IN (SELECT SNO 
              FROM SUBJECTS 
              WHERE TITLE IN ('HTML5','아두이노'));


/* [UNION(합집합 연산자)]
 * - SELECT 결과를 합치기 
 */
SELECT DISTINCT (SELECT NAME 
                 FROM TRAINERS T2 
                 WHERE T2.TNO = T1.TNO) AS '강사명'
FROM SUB_TRAI T1
WHERE SNO = 1 
/* 결과: 홍길동 유관순 안중근 윤봉길 */
UNION

SELECT DISTINCT (SELECT NAME 
                 FROM TRAINERS T2 
                 WHERE T2.TNO = T1.TNO) AS '강사명'
FROM SUB_TRAI T1
WHERE SNO = 2;
/* 결과: 홍길동 안중근 */
/* 합집합 결과: 홍길동 유관순 안중근 윤봉길 => 집합은 데이터 중복을 허용하지 않는다! */


/* UNION ALL : 합집합을 수행할 때 중복 데이터를 제거하지 않는다. */
SELECT DISTINCT (SELECT NAME 
                 FROM TRAINERS T2 
                 WHERE T2.TNO = T1.TNO) AS '강사명'
FROM SUB_TRAI T1
WHERE SNO = 1 
/* 결과: 홍길동 유관순 안중근 윤봉길 */
UNION ALL

SELECT DISTINCT (SELECT NAME 
                 FROM TRAINERS T2 
                 WHERE T2.TNO = T1.TNO) AS '강사명'
FROM SUB_TRAI T1
WHERE SNO = 2;
/* 결과: 홍길동 안중근 */
/* 합집합 결과: 홍길동 유관순 안중근 윤봉길 홍길동 안중근 => 중복 데이터 허용! */

/* 용어 정리!
 * Selection : WHERE 절을 통해 특정 조건을 갖는 행을 추출하는 것.
 * Projection : SELECT 절을 통해 추출된 행 중에서 특정 컬럼의 값만 선택하는 것.
 */
SELECT NAME 
FROM LECTURES 
WHERE TITLE = '[자바%';
/* Selection: 강의 명이 '[자바'로 시작하는 강의를 모두 추출한다.
 * Projection : 추출된 결과에서 NAME 컬럼의 값만 선택한다.
 */









