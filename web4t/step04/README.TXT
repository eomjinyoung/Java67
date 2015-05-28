[4단계: view resolver]
1. JSP 파일을 외부에서 직접 접근할 수 없도록 막는다.
- MVC 아키텍처에서 JSP는 Controller가 준비한 데이터를 가지고
  화면을 생성하는 일을 한다.
- 따라서 JSP를 직접 실행하는 것은 의미가 없다.
- [방법]
  /WEB-INF 폴더에 JSP 파일을 둔다.
  /WEB-INF 폴더는 외부에서 접근할 수 없기 때문이다.
- 주의 사항!
  HTML, CSS, JavaScript, Image 파일은 외부에서 직접 접근해야 하기 때문에,
  /WEB-INF 폴더에 두어서는 안된다. 


2. /WEB-INF 폴더에 있는 JSP를 실행할 수 있도록 View Resolver를 설정한다.
- 프론트 컨트롤러의 스프링 설정 파일에 
  InternalResourceViewResolver 객체를 등록하라!
  
3. InternalResourceViewResolver 도입에 맞추어 
   페이지 컨트롤러가 리턴하는 JSP URL을 수정하라!     

[CRUD를 하나의 클래스로 묶는다]
- CRUD 각각의 코드 크기가 작다면 하나의 클래스로 묶는 것이 유지보수에 좋다.
- BoardListController, BoardDetailController, BoardXxxController
  => BoardController 

[@RequestMapping 애노테이션 속성]
1. method 속성 (예제: ...web.ex3.PageController01)
- 요청 방식을 구분할 때 사용한다.
- 설정하지 않으면 모든 요청 방식에 대해 메서드가 호출된다.

2. params 속성
- 파라미터가 있는 경우에만 호출되게 제한한다.

3. headers 속성
- 특정 헤더가 있는 경우에만 호출되게 제한한다.

4. produces 속성
- Accept 요청 헤더의 값과 일치하는 경우에만 호출되게 제한한다.

5. consumes 속성
- POST 요청에서 Content-Type 헤더 값과 일치하는 경우에만 호출되게 제한한다. 















  

