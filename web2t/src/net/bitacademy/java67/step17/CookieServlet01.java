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
 * - 쿠키 값은 반드시 문자열이어야 한다.
 * - HTTP 응답 프로토콜의 헤더 값으로 보내기 때문에 객체를 보낼 수 없다.
 * 
 */
@WebServlet("/step17/cookie01")
public class CookieServlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    //1) 쿠키 생성
    Cookie cookie = new Cookie("name", "hongkildong");
    Cookie cookie2 = new Cookie("age", "20");
    
    response.addCookie(cookie);
    response.addCookie(cookie2);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("쿠키 보냄!!");
    
    /* HTTP 응답 프로토콜의 예
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Set-Cookie: name=hongkildong     <-------- 서버에서 클라이언트로 쿠키를 보내는 방법 
Set-Cookie: age=20               <-------- 서버에서 클라이언트로 쿠키를 보내는 방법
Content-Type: text/plain;charset=UTF-8
Content-Length: 16
Date: Fri, 29 May 2015 05:58:41 GMT 
     */
    
    /* 클라이언트 측 행동 
     * - 서버로부터 쿠키를 받으면, 타임아웃 시간이 설정되었는지 조사한다.
     * 1) timeout
     * - 만약 타임아웃 시간이 설정되지 않았다면,
     *   => 메모리에 쿠키 값을 보관한다.
     *   => 웹 브라우저가 종료되면 메모리에 보관된 쿠키 값도 삭제된다.
     *   => 곧 웹 브라우저가 실행되는 동안만 쿠키 정보는 유지된다.
     * - 만약 타임아웃 시간이 설정되었다면,
     *   => 외부 저장장치(HDD)에 보관한다. 웹 브라우저마다 쿠키를 보관하는 폴더가 있다.
     *   => 타임아웃이 끝나지 않았다면, 서버에 요청할 때마다 전달한다.
     *   => 웹 브라우저를 종료했다가 다시 실행하더라도 쿠키 정보를 유지된다.
     *   => 웹 브라우저는 서버에 요청할 때,
     *      쿠키의 타임아웃을 조사하여 시간이 경과된 쿠키는 삭제한다.
     *      
     * 2) path
     * - 만약 쿠키에 경로를 설정하지 않는다면,
     *   => 클라이언트는 같은 경로의 서블릿을 요청할 때만 쿠키를 보낸다.
     *   => 물론 같은 경로의 하위 경로인 경우에도 쿠키를 보낸다.
     * - 만약 쿠키에 경로를 설정했다면,
     *   => 설정한 경로로 요청할 때만 쿠키를 보낸다.
     */
    
  }
}











