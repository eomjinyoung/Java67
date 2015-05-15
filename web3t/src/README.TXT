[실습 목표]
- mybatis 퍼시스턴스(persistence) 프레임워크 적용
  
[OOP vs CBD vs Framework]
클래스: 변수와 메서드의 묶음. 
컴포넌트: 한 개 이상의 클래스의 묶음. 업무 로직의 기능을 수행.
설계 패턴: 특정 문제를 해결할 때 널리 사용되는 설계 방법론. 검증된 설계 기법. 

OOP: 클래스를 조립하여 애플리케이션 만들자!
CBD(Component-based Development): 중간 부품을 조립하여 애플리케이션을 만들자.
Framework: 어느 정도 애플리케이션의 골격을 준비한 다음, 필요한 부품을 꼽아서 애플리케이션을 만들자.
 

          [OOP]                [CBD]               [Framework]
기본 단위:  클래스                 컴포넌트              클래스 + 컴포넌트 + 설계 패턴

생활 개념:  다이오드, 저장, 납,      메인보드, 랜카드,       베어본(프레임워크),        
          나사, 칩, 트랜지스터 등   VGA 카드, 모듈램,       CPU(클래스),
                               케이스, 전원공급기 등    모듈램(컴포넌트) 등 
                               
속도:      가장 느리다             빠르다               가장 빠르다

난이도:    가장 어렵다             중간                 쉽다
  
개발자:     고급                 중급, 초급             초급

안정성:     개발자의 역량에 영향     중간, 컴포넌트 별로      최소한의 품질을 보장한다.
                              테스트 완료 했음.                          
                              
[퍼시스턴스 프레임워크]
- 데이터의 보관을 처리하는 기능을 수행.
1) SQL 맵퍼
  => SQL을 별도의 파일로 분리해놓고, 프레임워크에서 제공하는 클래스를 사용하여 
     SQL문을 실행한다.
  => SQL문을 개발자가 직접 작성한다. 
     단점: 개발자가 SQL문을 알아야 한다. DBMS 마다 SQL문을 따로 관리해야 한다.
     장점: DBMS 고유의 기능을 100% 활용할 수 있어, 최적화된 질의를 수행할 수 있다.
          기존의 시스템(레거시 시스템)이 사용하는 테이블을 직접 활용하기 쉽다. 
  => 대표 제품: mybatis
          
2) OR 맵퍼                              
  => 테이블의 데이터를 객체로 다룬다.
  => 객체 질의 전용 문법이 제공된다. 예) HQL(Hibernate Query Language)
  => SQL문과 유사하다.
  => 실제 실행할 때는 프레임워크에서 객체 질의어를 SQL문으로 자동 변환한 다음에 실행한다.
     장점: 개발자가 SQL문을 몰라도 된다. DBMS마다 SQL문을 따로 관리하지 않아도 된다.
     단점: DBMS 고유 기능을 100% 활용할 수 없다. 
          객체로 다룰 수 있도록 DB의 정규화가 잘 되어 있어야 한다.
          기존 시스템이 사용하는 테이블과의 연동이 어렵다.
  => 대표 제품: hibernate, toplink
  
[mybatis 프레임워크 사용 준비]
1. mybatis 라이브러리 다운로드  
- mybatis.org 사이트에 접속한다.
- 파일 다운로드

2. 라이브러리를 웹 애플리케이션에 추가
- mybatis-xxx.jar 과 lib 폴더에 있는 모든 JAR파일을 
  /WEB-INF/lib 폴더에 복사한다.

3. mybatis 설정 파일을 준비한다.
- dao 패키지에 mybatis-config.xml 파일을 생성한다.
- mybatis 문서에서 getting started에 설명한 대로 설정파일을 작성한다.

[SQL 파일 준비]
1. dao 패키지에 BoardDao.xml 파일을 생성한다.
2. getting started에 설명한 대로 루트 태그를 준비한다.
  <mapper> 태그
  namespace: SQL문을 찾을 때 사용할 패키지 이름이다.
             가능한 유지보수하기 좋게 Dao 클래스 이름(패키지명 포함)과 같게하라!  
3. BoardDao 클래스의 SQL문을 BoardDao.xml 파일로 옮긴다.   
  insert 문은 <insert> 태그에 작성한다.
  select --> <select>
  update --> <update>
  delete --> <delete>
  유지보수하기 좋게 각 SQL문의 ID는 메서드 이름과 같게 하라!
  <insert> 태그에 select 문을 넣어도 실행된다. 하지만, 유지보수를 위해 그렇게 하지 말라!
  
- SQL 태그 작성 규칙
  id : SQL을 구분하는 식별자이고, 해당 네임스페이스에서 유일해야 한다.
  parameterType: SQL의 입력 파라미터(in-parameter)에 넣을 값을 갖고 있는 객체이다. 
                 Fully-qualified name 이어야 한다.       
  resultType: SELECT 결과의 한 레코드 값을 담을 객체를 지정한다.
              레코드가 여러 개일 경우 mybatis는 List 객체를 만들어 저장한다.
                 
- in-parameter는 JDBC의 물음표(?) 대신 #{프로퍼티명} 형태로 지정한다.
  주의1) 문자열이라고 해서 다음과 같이 따옴표를 붙여서는 안된다.
        '#{title}' <-- 무조건 따옴표 안의 내용은 값이 된다.
  주의2) in-parameter는 테이블 이름이나 컬럼 이름을 받을 수는 없다.
        SQL 문의 일부분을 넣고 싶다면 ${SQL문}를 사용해야 한다.
        => 보안을 위협한다. mysql에서도 사용하지 말 것을 권고하고 있다.
           정부 프로젝트는 이것을 사용을 허용하지 않는다. 
           보안 검사를 통과하지 못한다. 
  참고1)
      in-parameter 타입이 wrapper 클래스일 경우, 
      => #{}에 사용할 프로퍼티 이름은 마음대로 적어도 된다.
      
- 결과 값을 객체에 담는 규칙
  컬럼명과 일치하는 프로퍼티를 찾는다. 있으면 setter를 호출하여 담는다. 없으면 안 담는다.
  만약 컬럼명과 프로퍼터명이 같지 않다면, 컬럼에 프로퍼티 이름과 같게 별명을 부여하라!  
 
- mybatis에서 제공하는 type 단축키
  java.lang.Integer       -> int
  java.lang.Long          -> long
  java.lang.String        -> string
  ... 
 
[BoardDao 클래스에 mybatis 적용]
1. 의존 객체 SqlSessionFactory를 담을 변수와 셋터 메서드를 준비한다.
- 기존의 DataSource 변수 및 셋터 메서드는 제거한다. 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 