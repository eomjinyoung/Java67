[실습 목표: 코드 정리]
- 객체를 준비시키고 객체를 찾아주는 기능을 분리하여 별도의 클래스로 정의한다.
  => ApplicationContext

1. ApplicationContext 클래스 정의
- ...java67.context.AppliationContext 클래스 생성
- ContextLoaderListener의 객체 생성 코드를 ApplicationContext로 옮긴다.

2. ApplicationContext 클래스에 Singleton 패턴을 적용한다.

3. ContextLoaderListener 클래스를 변경한다.

4. DispatcherServlet 클래스를 변경한다.

   
 
 
 
 
 
 
 
 