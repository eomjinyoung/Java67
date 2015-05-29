package net.bitacademy.java67.step17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 쿠키 경로 지정하기
 * - 쿠키의 사용 범위를 지정할 수 있다.
 * 
 */
@WebServlet("/step17/cookie03")
public class CookieServlet03 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    //1) 쿠키 경로 지정하기
    //- 쿠키의 경로를 지정하면,
    //  웹브라우저는 그 경로의 서블릿을 요청할 때마다 쿠키를 보낸다.
    //  물론, 그 경로의 하위 경로도 포함한다.
    Cookie cookie = new Cookie("name", "puhaha. OTL, orz");
    cookie.setPath("/web2t");
    
    //2) 쿠키 경로를 지정하기 않기
    //- 현재 서블릿의 경로가 쿠기의 경로로 사용된다.
    //  곧 현재 서블릿의 경로로 요청을 할때만 쿠키를 보낸다.
    //  물론, 하위 경로 포함.
    Cookie cookie2 = new Cookie("age", "30");
    
    response.addCookie(cookie);
    response.addCookie(cookie2);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("쿠키 보냄!!");
    
    /* HTTP 응답 프로토콜의 예
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Set-Cookie: name="puhaha. OTL, orz"; Version=1; Path=/web2t
Set-Cookie: age=30
Content-Type: text/plain;charset=UTF-8
Content-Length: 16
Date: Fri, 29 May 2015 07:24:36 GMT 
     */
  }
}











