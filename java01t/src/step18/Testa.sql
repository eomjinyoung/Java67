/* 조인
 * => 분산되어 있는 데이터를 한군데로 가져오는 방법
 * 
 * 1) CROSS 조인 : CARTESIAN 조인이라고도 부름.
 * - 무식한 조인. 무조건 1:1 조인
 * - 쓰레기 데이터를 포함한다.
 */
-- 강의 데이터와 교실 데이터를 묶어서 출력하기
SELECT T1.TITLE, T2.LOC, T2.ROOM
FROM LECTURES T1, CLASSROOMS T2;

-- SQL-1999 스펙 표준 문법
SELECT T1.TITLE, T2.LOC, T2.ROOM
FROM LECTURES T1 CROSS JOIN CLASSROOMS T2;

/* 2) NATURAL 조인 : 공통 컬럼을 기준으로 조인(레코드를 묶는다).*/
SELECT T1.TITLE, T2.LOC, T2.ROOM
FROM LECTURES T1, CLASSROOMS T2
WHERE T1.CNO = T2.CNO;

-- SQL-1999 스펙 표준 문법
-- 같은 이름을 가진 컬럼을 기준으로 조인한다. 이름이 다르면 안된다.
SELECT T1.TITLE, T2.LOC, T2.ROOM
FROM LECTURES T1 NATURAL JOIN CLASSROOMS T2;


/* 3) JOIN ~ USING
 * => 두 테이블에 이름이 같은 컬럼이 여러 개 있을 경우, 
 *    조인할 컬럼을 명시적으로 지정하는 방법. 
 */
-- SQL-1999 스펙 표준 문법
SELECT T1.TITLE, T2.LOC, T2.ROOM
FROM LECTURES T1 JOIN CLASSROOMS T2 USING(CNO);


/* 4) JOIN ~ ON
 * => 두 테이블을 조인할 때 사용할 컬럼 이름이 서로 다를 때.
 */
-- SQL-1999 스펙 표준 문법
SELECT T1.TITLE, T2.LOC, T2.ROOM
FROM LECTURES T1 JOIN CLASSROOMS T2 ON T1.CNO = T2.CNO;

/* 5) LEFT OUTER JOIN ~ ON
 * => 기존의 조인 방식은 조인이 되지 않은 데이터를 결과에서 제외하는 문제점이 있다.
 * => 왼쪽 테이블의 값을 기준으로 조인을 수행한다. 왼쪽 테이블의 값은 모두 결과에 포함된다.
 */
SELECT T1.TITLE, T2.LOC, T2.ROOM
FROM LECTURES T1 LEFT OUTER JOIN CLASSROOMS T2 ON T1.CNO = T2.CNO;

/* 6) RIGHT OUTER JOIN ~ ON
 * => 오른쪽 테이블을 기준으로 왼쪽 테이블과 조인한다. 오른쪽 테이블의 값은 모두 결과에 포함된다.
 */
SELECT T1.TITLE, T2.LOC, T2.ROOM
FROM LECTURES T1 RIGHT OUTER JOIN CLASSROOMS T2 ON T1.CNO = T2.CNO;

/* [조인 연습] */
-- 강사 이름, 과목명, 전화번호 
SELECT T1.NAME, T1.TEL, T2.SNO, T3.TITLE
FROM TRAINERS T1 LEFT OUTER JOIN SUB_TRAI T2 ON T1.TNO = T2.TNO
                 LEFT OUTER JOIN SUBJECTS T3 ON T2.SNO = T3.SNO;

-- 강의명, 장소, 교실, 매니저명



















