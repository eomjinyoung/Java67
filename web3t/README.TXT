[실습 목표: 요청이 들어왔을 때 호출되는 메서드에 애노테이션을 붙여 표시한다.]
- Controller 인터페이스를 제거한다.
- 요청을 처리할 메서드(request handler)를 자유 형식으로 작성하게 한다.

1. @RequestMapping 애노테이션 정의

2. 페이지 컨트롤러의 메서드에 @RequestMapping 애노테이션 붙인다.

3. DispatcherServlet(프론트 컨트롤러) 변경
- 클래스 정보로부터 호출할 메서드를 알아낸다.
- 해당 메서드를 호출한다.










 
 
 
 
 
 
 
 