package net.bitacademy.java67.step17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 클라이언트에 쿠키 보내기
 * - 타임아웃 지정하기
 * 
 */
@WebServlet("/step17/cookie02")
public class CookieServlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    //1) 타임아웃이 지정된 쿠키
    //- 웹브라우저에서 관리하는 별도의 폴더에 저장한다.
    //- 모든 웹브라우저를 종료했다가 다시 실행하더라도 쿠키는 유지된다.
    //- 타임아웃을 넘긴 쿠키는 요청할 때 삭제한다.
    Cookie cookie = new Cookie("name", "haha");
    cookie.setMaxAge(60); // 60초 동안 유지된다.
    
    //2) 타임아웃이 지정되지 않은 쿠키
    //- 웹브라우저가 메모리에 보관한다.
    //- 같은 웹브라우저는 쿠키를 공유한다.
    //- 모든 웹브라우저를 종료하면 당연히 쿠키가 삭제된다.
    Cookie cookie2 = new Cookie("age", "30");
    
    response.addCookie(cookie);
    response.addCookie(cookie2);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("쿠키 보냄!!");
    
    /* HTTP 응답 프로토콜의 예
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Set-Cookie: name=haha; Expires=Fri, 29-May-2015 07:15:21 GMT
Set-Cookie: age=30
Content-Type: text/plain;charset=UTF-8
Content-Length: 16
Date: Fri, 29 May 2015 07:14:21 GMT 
     */
  }
}











