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
 * - PageServlet03은 세션을 사용하여 클라이언트가 보낸 age 값을 보관한다.
 * - getSession()을 호출, 기존의 HttpSession 객체를 리턴한다.
 */

@WebServlet("/step18/page03")
public class PageServlet03 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    //1) 클라이언트에서 세션 ID를 쿠키(JSESSIONID)를 통해 전달했다.
    //- 세션 ID에 해당하는 HttpSession 객체를 찾아서 리턴한다.
    HttpSession session = request.getSession();
    
    //2) 세션에 클라이언트가 보낸 데이터를 보관한다.
    session.setAttribute("age", request.getParameter("age"));
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body><h1>페이지3</h1>");
    out.println("<form action='page04' method='post'>");
    out.println("전화: <input type='text' name='tel'><br>");
    out.println("<button>다음</button>");
    out.println("</form></body></html>");
    
    /* HTTP 요청 프로토콜 : 이전에 보관한 세션 ID값을 쿠키로 보낸다.
GET /web2t/step18/page03 HTTP/1.1
Host: localhost:9999
Connection: keep-alive
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*|*;q=0.8
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
Cookie: JSESSIONID=D713788A19778593813ACD556A378AF6; name="puhaha. OTL, orz"
Name  
     */
  }
  
}











