<%@ page  language="java" 
          contentType="text/plain; charset=UTF-8"
          pageEncoding="UTF-8"%>
JSP란?
- 출력문을 자동 생성하는 기술이다.
- JSP 파일을 읽어서 서블릿 클래스를 생성한다. 
- 템플리 데이터는 out.println(), out.write() 등의 출력문을 생성한다.
- 톰캣 서버의 경우, 임시 배치 폴더의 work 디렉토리에 자동으로 생성된 서블릿 파일을 둔다.
  서블릿 파일이 놓이는 폴더 ==> ...tmp0/work/...
- 클래스 이름은 서블릿 컨테이너가 임의로 짓는다.
- JSP 파일은 직접 실행되지 않는다. 단지 서블릿 클래스를 만들기 위한 재료로 사용될 뿐이다.

언제 JSP 파일을 가지고 서블릿 클래스를 생성하는가?
- JSP를 최초로 요청할 때,
- JSP 파일이 변경되었을 때,

[JSP 구동원리]
1) 클라이언트에서 JSP 실행을 요청

2) 서블릿 컨테이너는 JSP로 만든 서블릿 클래스를 찾는다.

3-1) 만약 없다면,
   - JSP 파일을 분석하여 서블릿 클래스 파일을 만든다.(JSP 엔진)
   - 컴파일 한다.

3-2) 만약 JSP 파일이 변경되었다면,
   - JSP 파일을 분석하여 서블릿 클래스 파일을 만든다.(JSP 엔진)
   - 컴파일 한다.
    
4) 해당 서블릿의 service() 메서드를 호출한다.
   
[JSP 컴파일 규약]
JSP 파일을 가지고 서블릿 클래스를 생성할 때 지켜야할 규약.
HttpJspPage 인터페이스를 구현하라!
Servlet <--------------- JspPage <--------- HttpJspPage
.init()                 .jspInit()          ._jspService()
.destroy()              .jspDestroy()
.getServletInfo()
.getServletConfig()
.service()


1) HttpServlet을 상속 받든, GenericServlet을 상속 받든, 
   Servlet 인터페이스를 직접 구현하던지, 세가지 방법을 동원하여
   서블릿 클래스를 정의한다.   

2) JspPage 인터페이스를 구현해야 한다.
=> jspInit() : init()에서 jspInit()를 호출하도록 작성한다.
=> jspDestroy() : destroy()에서 jspDestroy()를 호출하도록 작성한다.

3) HttpJspPage 인터페이스를 구현해야 한다.
=> _jspService) : service()에서 _jspService()를 호출하도록 작성한다.
   
예)
public class MyJspServlet 
  extends HttpServlet
  implements HttpJspPage {
  
  @Override
  public void init(ServletConfig config) {
    super.init();
    jspInit();  // 규약을 만족시킴.
  }
  
  @Override
  public void destroy() {
    super.destroy();
    jspDestroy(); // 규약을 만족시킴.
  }
  
  public void jspInit() {}
  public void jspDestroy() {}
  public void _jspService(HttpServletRequest req, HttpServletResponse rep) {
    ...
  }
}   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   