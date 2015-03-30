/* 1. MySQL 서버 접속
 * 
 * > mysql -u 사용자ID -p
 * Enter password: 사용자암호
 * 
 * 예:
 * > mysql -u java67 -p
 * Enter password: java67
 * ...
 * 
 * 
 * mysql? MySQL 서버에 작업을 요청할 때 사용하는 클라이언트 프로그램.
 * 
 * 
 * 2. MySQL 서버에 준비된 데이터베이스 정보 알아내기
 * > show databases;
 * 데이터베이스 목록을 출력한다.
 * 
 * 3. 사용할 데이터베이스(스키마) 지정하기
 * > connect 데이터베이스이름;
 * 
 * 예:
 * > connect java67db;
 * 
 * 
 * 4. 데이터베이스에 존재하는 테이블 알아내기
 * > show tables;
 * 현재 접속한 데이터베이스의 모든 테이블 이름을 출력한다.
 * 
 * 5. MySQL 클라이언트 프로그램 종료하기
 * > quit;
 * 
 */