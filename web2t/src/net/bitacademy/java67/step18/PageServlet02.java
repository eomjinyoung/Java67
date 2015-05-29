package net.bitacademy.java67.step18;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 실습 목표: 세션 사용
 * - PageServlet02는 세션을 사용하여 클라이언트가 보낸 name 값을 보관한다.
 * - getSession()을 호출
 *   1) 요청 헤더에 세션 ID 값을 갖는 쿠키가 없다.
 *      => 새로 HttpSession 객체를 생성하여 리턴한다.
 *   
 *   2) 요청 헤더에 세션 ID 값을 갖는 쿠키가 있다.
 *      => 세션 ID에 해당하는 HttpSession 객체를 찾는다.
 *      2-1) 아직 timeout 되지 않았다.
 *           => 세션이 유효하므로, 기존 HttpSession 객체를 리턴한다.
 *      2-2) timeout 시간을 초과했다.
 *           => 기존 HttpSession 객체를 삭제하고, 새로 HttpSession 객체를 만들어 리턴한다.
 *           
 *   => 세션 객체를 새로 만들면, 세션 ID 값을 쿠키에 담아서 응답 헤더에 붙인다. 
 */

@WebServlet("/step18/page02")
public class PageServlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    //1) 클라이언트에서 세션 ID를 알려주지 않았기 때문에 새로 세션을 만들 것이다.
    HttpSession session = request.getSession();
    
    //2) 세션에 클라이언트가 보낸 데이터를 보관한다.
    session.setAttribute("name", request.getParameter("name"));
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body><h1>페이지2</h1>");
    out.println("<form action='page03' method='post'>");
    out.println("나이: <input type='text' name='age'><br>");
    out.println("<button>다음</button>");
    out.println("</form></body></html>");
    
    /* HTTP 응답 프로토콜 : 세션 ID값을 포함한 쿠키가 있다.
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Set-Cookie: JSESSIONID=D713788A19778593813ACD556A378AF6; Path=/web2t/; HttpOnly
Content-Type: text/html;charset=UTF-8
Content-Length: 158
Date: Fri, 29 May 2015 08:24:32 GMT
     */
    
    
    /* 세션 ID 쿠키 
     * - 경로가 웹 애플리케이션이다.
     * - 따라서 웹 애플리케이션의 모든 서블릿이나 JSP를 요청할 때 세션 ID를 서버에 제시한다. 
     */
  }
  
}











