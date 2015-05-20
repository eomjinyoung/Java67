[실습 목표: 애노테이션을 이용하여 객체 관리하기]
- properties 파일에 작성한 객체 정보를 애노테이션으로 옮긴다.
- 객체를 생성할 때마다 properties 파일을 변경할 필요가 없다. 

1. Bean(객체) 관리를 위한 애노테이션 정의
- @Component 애노테이션 선언

2. 컨트롤러와 DAO 등 관리 대상이 되는 클래스에 애노테이션을 붙인다. 

3. ApplicationContext 클래스 변경.
- 애노테이션을 추출하여 객체를 생성한다. 

[Reflections 라이브러리 사용]
1. 다운로드
- https://code.google.com/p/reflections/ 페이지에 접속한다.
- 1) reflections가 의존하는 라이브러리 다운로드 한다.
      => reflections-0.9.9-RC1-uberjar.jar
- 2) reflections 라이브러리를 다운로드 한다.
      => reflections-0.9.9-RC1.jar
      
2. 압축 해제
- reflections-0.9.9-RC1-uberjar.jar 파일을 압축 해제한다.
  이 파일에서는 의존 라이브러리와 클래스 파일이 들어 있다. 

3. /WEB-INF/lib 폴더에 라이브러리 파일 복사
- 의존 라이브러리 파일과 reflections-0.9.9-RC1.jar 파일을 넣는다.

4. ApplicationContext 클래스 변경
- 파일 입출력 API를 사용하는 대신에, Reflections 라이브러리를 사용하여 
  @Component가 붙은 클래스를 찾는다.











 
 
 
 
 
 
 
 