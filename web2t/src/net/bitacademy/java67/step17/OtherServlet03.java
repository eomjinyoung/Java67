package net.bitacademy.java67.step17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 클라이언트가 보낸 쿠키 꺼내기
 * 
 */
@WebServlet("/step17x/other03")
public class OtherServlet03 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("/step17x/other03");

    //1) 쿠키 꺼내기
    //- 요청 프로토콜에서 Cookie 헤더 값을 꺼낸다.
    Cookie[] cookies = request.getCookies();

    //2) 쿠키 값 출력하기
    if (cookies != null) {
      for (Cookie c : cookies) {
        out.printf("%s=%s\n", c.getName(), c.getValue());
      }
    }
    
    /* HTTP 요청 프로토콜에 포함된 쿠키 정보 
GET /web2t/step17/other01 HTTP/1.1
Host: localhost:9999
Connection: keep-alive
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*|*;q=0.8
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
Cookie: name=hongkildong; age=20      <---- 요청할 때마다 서버로부터 받은 쿠키 정보를 보낸다.
     */
  }
}











