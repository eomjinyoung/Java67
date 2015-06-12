[9단계: 트랜잭션 다루기]
1. 게시글의 변경 내역을 저장할 테이블을 생성한다.
create table board_log (
  blno INT NOT NULL,      /* 게시물 등록,변경,삭제 활동 번호*/
  ip VARCHAR(20) NOT NULL, /* 클라이언트 IP 주소 */
  act_dt DATETIME NOT NULL, /* 활동 날짜 및 시간 */
  act_type CHAR(1) NOT NULL, /* 활동 유형: I(nsert), U(pdate), D(elete)*/
  bno INT NOT NULL  /* 대상 게시물 번호 */
);

ALTER TABLE board_log
  ADD CONSTRAINT board_log_pk PRIMARY KEY(blno);

ALTER TABLE board_log
  MODIFY COLUMN blno INT NOT NULL AUTO_INCREMENT;  

2. SQL 준비
- BoardLogDao.xml 파일 작성
- BoardDao.xml 파일 변경
  => INSERT 후에 자동 생성된 번호를 리턴하도록 한다.   
  => useGeneratedKeys 속성의 값을 true로 설정하면,
    INSERT 할 때 자동 생성된 bno 값을 파라미터 객체에 꺼꾸로 설정해 준다.
  <insert id="insert" parameterType="BoardVo"
        keyColumn="bno" keyProperty="no" useGeneratedKeys="true">
      INSERT INTO board2 (title,content,cre_date) 
      VALUES (#{title},#{content},now())
  </insert>
    
3. Value Object 작성
- BoardLogVo 클래스 작성  

4. DAO 인터페이스 작성
- BoardLogDao 인터페이스 작성

5. Service 클래스 작성
- BoardService 클래스 작성
- BoardController 클래스의 코드 중에서 비즈니스 로직 관련 코드를 BoardService로 옮긴다.

















