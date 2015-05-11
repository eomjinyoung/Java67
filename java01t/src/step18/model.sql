-- 수강신청
DROP TABLE IF EXISTS LEC_APPL RESTRICT;

-- 교실사진
DROP TABLE IF EXISTS CR_PHOTO RESTRICT;

-- 강의
DROP TABLE IF EXISTS LECTURES RESTRICT;

-- 강사
DROP TABLE IF EXISTS TRAINERS RESTRICT;

-- 매니저
DROP TABLE IF EXISTS MANAGERS RESTRICT;

-- 강의장
DROP TABLE IF EXISTS CLASSROOMS RESTRICT;

-- 학생
DROP TABLE IF EXISTS STUDENTS RESTRICT;

-- 강사배정
DROP TABLE IF EXISTS LEC_TRAI RESTRICT;

-- 강의과목
DROP TABLE IF EXISTS SUBJECTS RESTRICT;

-- 강사강의과목
DROP TABLE IF EXISTS SUB_TRAI RESTRICT;

-- 수강신청
CREATE TABLE LEC_APPL (
  LNO     INTEGER NOT NULL COMMENT '강의번호', -- 강의번호
  SNO     INTEGER NOT NULL COMMENT '학생번호', -- 학생번호
  AP_DATE DATE    NOT NULL COMMENT '신청일', -- 신청일
  STATE   INTEGER NULL     COMMENT '신청결과' -- 신청결과
)
COMMENT '수강신청';

-- 수강신청
ALTER TABLE LEC_APPL
  ADD CONSTRAINT PK_LEC_APPL -- 수강신청 기본키
    PRIMARY KEY (
      LNO, -- 강의번호
      SNO  -- 학생번호
    );

-- 교실사진
CREATE TABLE CR_PHOTO (
  CPNO  INTEGER      NOT NULL COMMENT '교실사진번호', -- 교실사진번호
  PHOTO VARCHAR(255) NOT NULL COMMENT '교실사진', -- 교실사진
  CNO   INTEGER      NOT NULL COMMENT '강의장번호' -- 강의장번호
)
COMMENT '교실사진';

-- 교실사진
ALTER TABLE CR_PHOTO
  ADD CONSTRAINT PK_CR_PHOTO -- 교실사진 기본키
    PRIMARY KEY (
      CPNO -- 교실사진번호
    );

ALTER TABLE CR_PHOTO
  MODIFY COLUMN CPNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '교실사진번호';

-- 강의
CREATE TABLE LECTURES (
  LNO     INTEGER      NOT NULL COMMENT '강의번호', -- 강의번호
  TITLE   VARCHAR(255) NOT NULL COMMENT '강의명', -- 강의명
  INTRO   TEXT         NULL     COMMENT '강의소개', -- 강의소개
  CAPA    INTEGER      NOT NULL COMMENT '최대인원', -- 최대인원
  ST_DATE DATE         NOT NULL COMMENT '강의시작일', -- 강의시작일
  ED_DATE DATE         NOT NULL COMMENT '강의종료일', -- 강의종료일
  HOURS   INTEGER      NOT NULL COMMENT '총강의시간', -- 총강의시간
  DAYS    INTEGER      NOT NULL COMMENT '총강의일수', -- 총강의일수
  CNT     INTEGER      NULL     COMMENT '확정인원', -- 확정인원
  MNO     INTEGER      NULL     COMMENT '매니저번호', -- 매니저번호
  CNO     INTEGER      NULL     COMMENT '강의장번호' -- 강의장번호
)
COMMENT '강의';

-- 강의
ALTER TABLE LECTURES
  ADD CONSTRAINT PK_LECTURES -- 강의 기본키
    PRIMARY KEY (
      LNO -- 강의번호
    );

ALTER TABLE LECTURES
  MODIFY COLUMN LNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의번호';

-- 강사
CREATE TABLE TRAINERS (
  TNO   INTEGER      NOT NULL COMMENT '강사번호', -- 강사번호
  NAME  VARCHAR(50)  NOT NULL COMMENT '강사명', -- 강사명
  PHOTO VARCHAR(255) NOT NULL COMMENT '강사사진', -- 강사사진
  TEL   VARCHAR(30)  NOT NULL COMMENT '강사전화', -- 강사전화
  EMAIL VARCHAR(40)  NOT NULL COMMENT '강사이메일', -- 강사이메일
  PWD   VARCHAR(20)  NOT NULL COMMENT '암호', -- 암호
  WAGE  INTEGER      NULL     COMMENT '강사시급', -- 강사시급
  ADDR  VARCHAR(255) NULL     COMMENT '강사주소' -- 강사주소
)
COMMENT '강사';

-- 강사
ALTER TABLE TRAINERS
  ADD CONSTRAINT PK_TRAINERS -- 강사 기본키
    PRIMARY KEY (
      TNO -- 강사번호
    );

-- 강사 유니크 인덱스
CREATE UNIQUE INDEX UIX_TRAINERS
  ON TRAINERS ( -- 강사
    EMAIL ASC -- 강사이메일
  );

-- 강사 인덱스
CREATE INDEX IX_TRAINERS
  ON TRAINERS( -- 강사
    NAME ASC -- 강사명
  );

ALTER TABLE TRAINERS
  MODIFY COLUMN TNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강사번호';

-- 매니저
CREATE TABLE MANAGERS (
  MNO   INTEGER      NOT NULL COMMENT '매니저번호', -- 매니저번호
  NAME  VARCHAR(50)  NOT NULL COMMENT '매니저명', -- 매니저명
  EMAIL VARCHAR(40)  NOT NULL COMMENT '매니저이메일', -- 매니저이메일
  PWD   VARCHAR(20)  NOT NULL COMMENT '암호', -- 암호
  PHOTO VARCHAR(255) NOT NULL COMMENT '매니저사진', -- 매니저사진
  TEL   VARCHAR(30)  NULL     COMMENT '매니저전화' -- 매니저전화
)
COMMENT '매니저';

-- 매니저
ALTER TABLE MANAGERS
  ADD CONSTRAINT PK_MANAGERS -- 매니저 기본키
    PRIMARY KEY (
      MNO -- 매니저번호
    );

-- 매니저 유니크 인덱스
CREATE UNIQUE INDEX UIX_MANAGERS
  ON MANAGERS ( -- 매니저
    EMAIL ASC -- 매니저이메일
  );

-- 매니저 인덱스
CREATE INDEX IX_MANAGERS
  ON MANAGERS( -- 매니저
    NAME ASC -- 매니저명
  );

ALTER TABLE MANAGERS
  MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '매니저번호';

-- 강의장
CREATE TABLE CLASSROOMS (
  CNO  INTEGER     NOT NULL COMMENT '강의장번호', -- 강의장번호
  LOC  VARCHAR(10) NOT NULL COMMENT '장소', -- 장소
  ROOM VARCHAR(10) NOT NULL COMMENT '교실', -- 교실
  CONTENT TEXT NULL COMMENT '설명' -- 설명
)
COMMENT '강의장';

-- 강의장
ALTER TABLE CLASSROOMS
  ADD CONSTRAINT PK_CLASSROOMS -- 강의장 기본키
    PRIMARY KEY (
      CNO -- 강의장번호
    );

-- 강의장 유니크 인덱스
CREATE UNIQUE INDEX UIX_CLASSROOMS
  ON CLASSROOMS ( -- 강의장
    LOC ASC,  -- 장소
    ROOM ASC  -- 교실
  );

ALTER TABLE CLASSROOMS
  MODIFY COLUMN CNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의장번호';

-- 학생
CREATE TABLE STUDENTS (
  SNO    INTEGER      NOT NULL COMMENT '학생번호', -- 학생번호
  NAME   VARCHAR(50)  NOT NULL COMMENT '학생명', -- 학생명
  PHOTO  VARCHAR(255) NULL     COMMENT '학생사진', -- 학생사진
  TEL    VARCHAR(30)  NOT NULL COMMENT '학생전화', -- 학생전화
  EMAIL  VARCHAR(40)  NOT NULL COMMENT '학생이메일', -- 학생이메일
  PWD    VARCHAR(20)  NOT NULL COMMENT '암호', -- 암호
  ADDR   VARCHAR(255) NULL     COMMENT '학생주소', -- 학생주소
  DEGREE INTEGER      NULL     COMMENT '학생학력', -- 학생학력
  WORK   CHAR(1)      NOT NULL COMMENT '직장인여부' -- 직장인여부
)
COMMENT '학생';

-- 학생
ALTER TABLE STUDENTS
  ADD CONSTRAINT PK_STUDENTS -- 학생 기본키
    PRIMARY KEY (
      SNO -- 학생번호
    );

-- 학생 유니크 인덱스
CREATE UNIQUE INDEX UIX_STUDENTS
  ON STUDENTS ( -- 학생
    EMAIL ASC -- 학생이메일
  );

ALTER TABLE STUDENTS
  MODIFY COLUMN SNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '학생번호';

-- 강사배정
CREATE TABLE LEC_TRAI (
  LNO     INTEGER NOT NULL COMMENT '강의번호', -- 강의번호
  TNO     INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
  ST_DATE DATE    NULL     COMMENT '강사투입일', -- 강사투입일
  EN_DATE DATE    NULL     COMMENT '강사철수일' -- 강사철수일
)
COMMENT '강사배정';

-- 강사배정
ALTER TABLE LEC_TRAI
  ADD CONSTRAINT PK_LEC_TRAI -- 강사배정 기본키
    PRIMARY KEY (
      LNO, -- 강의번호
      TNO  -- 강사번호
    );

-- 강의과목
CREATE TABLE SUBJECTS (
  SNO   INTEGER     NOT NULL COMMENT '강의과목번호', -- 강의과목번호
  TITLE VARCHAR(50) NOT NULL COMMENT '과목명' -- 과목명
)
COMMENT '강의과목';

-- 강의과목
ALTER TABLE SUBJECTS
  ADD CONSTRAINT PK_SUBJECTS -- 강의과목 기본키
    PRIMARY KEY (
      SNO -- 강의과목번호
    );

ALTER TABLE SUBJECTS
  MODIFY COLUMN SNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의과목번호';

-- 강사강의과목
CREATE TABLE SUB_TRAI (
  TNO INTEGER NOT NULL COMMENT '강사번호', -- 강사번호
  SNO INTEGER NOT NULL COMMENT '강의과목번호' -- 강의과목번호
)
COMMENT '강사강의과목';

-- 강사강의과목
ALTER TABLE SUB_TRAI
  ADD CONSTRAINT PK_SUB_TRAI -- 강사강의과목 기본키
    PRIMARY KEY (
      TNO, -- 강사번호
      SNO  -- 강의과목번호
    );

-- 수강신청
ALTER TABLE LEC_APPL
  ADD CONSTRAINT FK_LECTURES_TO_LEC_APPL -- 강의 -> 수강신청
    FOREIGN KEY (
      LNO -- 강의번호
    )
    REFERENCES LECTURES ( -- 강의
      LNO -- 강의번호
    );

-- 수강신청
ALTER TABLE LEC_APPL
  ADD CONSTRAINT FK_STUDENTS_TO_LEC_APPL -- 학생 -> 수강신청
    FOREIGN KEY (
      SNO -- 학생번호
    )
    REFERENCES STUDENTS ( -- 학생
      SNO -- 학생번호
    );

-- 교실사진
ALTER TABLE CR_PHOTO
  ADD CONSTRAINT FK_CLASSROOMS_TO_CR_PHOTO -- 강의장 -> 교실사진
    FOREIGN KEY (
      CNO -- 강의장번호
    )
    REFERENCES CLASSROOMS ( -- 강의장
      CNO -- 강의장번호
    );

-- 강의
ALTER TABLE LECTURES
  ADD CONSTRAINT FK_MANAGERS_TO_LECTURES -- 매니저 -> 강의
    FOREIGN KEY (
      MNO -- 매니저번호
    )
    REFERENCES MANAGERS ( -- 매니저
      MNO -- 매니저번호
    );

-- 강의
ALTER TABLE LECTURES
  ADD CONSTRAINT FK_CLASSROOMS_TO_LECTURES -- 강의장 -> 강의
    FOREIGN KEY (
      CNO -- 강의장번호
    )
    REFERENCES CLASSROOMS ( -- 강의장
      CNO -- 강의장번호
    );

-- 강사배정
ALTER TABLE LEC_TRAI
  ADD CONSTRAINT FK_LECTURES_TO_LEC_TRAI -- 강의 -> 강사배정
    FOREIGN KEY (
      LNO -- 강의번호
    )
    REFERENCES LECTURES ( -- 강의
      LNO -- 강의번호
    );

-- 강사배정
ALTER TABLE LEC_TRAI
  ADD CONSTRAINT FK_TRAINERS_TO_LEC_TRAI -- 강사 -> 강사배정
    FOREIGN KEY (
      TNO -- 강사번호
    )
    REFERENCES TRAINERS ( -- 강사
      TNO -- 강사번호
    );

-- 강사강의과목
ALTER TABLE SUB_TRAI
  ADD CONSTRAINT FK_TRAINERS_TO_SUB_TRAI -- 강사 -> 강사강의과목
    FOREIGN KEY (
      TNO -- 강사번호
    )
    REFERENCES TRAINERS ( -- 강사
      TNO -- 강사번호
    );

-- 강사강의과목
ALTER TABLE SUB_TRAI
  ADD CONSTRAINT FK_SUBJECTS_TO_SUB_TRAI -- 강의과목 -> 강사강의과목
    FOREIGN KEY (
      SNO -- 강의과목번호
    )
    REFERENCES SUBJECTS ( -- 강의과목
      SNO -- 강의과목번호
    );