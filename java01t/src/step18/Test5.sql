/* insert 문
 * 
 * 예1) 입력할 컬럼을 지정하지 않을 경우,
 * => 테이블을 생성할 때 선언한 컬럼 순서대로 값을 VALUES()에 나열해야 한다.
 */
INSERT INTO board
VALUES(5, 'eeeee', 'okokok', NOW(), 0, NULL);

-- 예2) 컬럼 순서를 바꿔도 상관없다. 대신 VALUES()는 그 컬럼 순서로 값을 나열해야 한다.
INSERT INTO board(content, cre_date, bno, title)
VALUES('OKOKOKO', NOW(), 6, 'ffffff');

-- 예3) 날짜 컬럼의 값 입력하기 => 따옴표 ''를 사용하여 날짜 값을 표현한다.
INSERT INTO board(bno, title, content, cre_date)
VALUES(7, 'gggggg', 'okokok', '2015-03-31');














