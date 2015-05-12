package net.bitacademy.java67.step10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: Forward 수행
 * - 오류가 발생하면 오류 페이지를 출력하는 서블릿으로 실행을 위임한다.
 */

@WebServlet("/step10/test01")
public class Test01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, 
        HttpServletResponse response)
      throws ServletException, IOException {
    
    try {
      int a = Integer.parseInt(request.getParameter("a"));
      int b = Integer.parseInt(request.getParameter("b"));
      String op = request.getParameter("op");
      
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      switch(op) {
      case "plus": out.println("계산 결과: " + (a + b)); break;
      case "minus": out.println("계산 결과: " + (a - b)); break;
      case "multiple": out.println("계산 결과: " + (a * b)); break;
      case "divide": out.println("계산 결과: " + (a / b)); break;
      default: out.println("지원하지 않는 연산자입니다.");
      }
    } catch (Throwable e) {
      // 오류가 발생한다면, 오류 내용을 출력하는 페이지로 보낸다. => forwarding
      // 주의!
      // - forward/include할 때 사용하는 주소는 서블릿 주소이다.
      // - 루트(/)는 현재 웹 애플리케이션 경로를 의미한다.
      //   예) /step01/error ==> localhost:9999/web2/step01/error
      //
      // - 웹 브라우저에 보내는 URL인 경우, 당연히 루트(/)는 서버 주소를 의미한다.
      //   예1) sendRedirect("/step10/error")?
      //   예2) setHeader("Refresh", "1;url=/step01/error");
      //        ==> localhost:9999/step01/error
      // 
      //   
      RequestDispatcher rd = request.getRequestDispatcher("/step10/error");
      request.setAttribute("error", e); // ErrorPage 서블릿에 오류 정보를 넘긴다.
      /* ServletRequest 보관소는 forward/include 하는 서블릿끼리 공유하기 때문에
       * 이 보관소에 데이터를 저장하면 포워드/인클루드 서블릿이 사용할 수 있다.
       */
      rd.forward(request, response);
      System.out.println("오류가 발생하여 포워딩함...");
    }
  }
}
















