package net.bitacademy.java67.step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: HttpServlet 클래스 사용
 * - service()의 파라미터를 원래의 타입으로 매번 형변환 할 필요가 없다.
 * - HTTP 프로토콜을 다루는 다양한 메서드가 구비되어 있다.
 * 
 * HttpServlet 클래스
 * - GenericServlet 클래스를 상속 받았다.
 * - HttpServletRequest와 HttpServletResponse 파라미터를 받는 
 *   service() 메서드를 추가하였다.(오버로딩)
 * - 원래 있던 service(ServletRequest, ServletResponse)는 
 *   새로 추가한 service(HttpServletRequest, HttpServletResponse)를 호출한다.
 *   
 * 클래스 계층도
 * Servlet (인터페이스)
 *    . init()
 *    . service()
 *    . destroy()
 *    . getServletInfo()
 *    . getServletConfig()
 *    
 * |--> GenericServlet (추상클래스)
 *       . init() {}
 *       . destroy() {}
 *       . getServletInfo() {}
 *       . getServletConfig() {}
 *       
 *     |--> HttpServlet (추상클래스)
 *          . service(ServletRequest, ServletResponse) {}
 *          . service(HttpServletRequest, HttpServletResponse) {}
 *          
 */
//@WebServlet("/step03/list")
public class BoardListServlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    List<BoardVo> list = new ArrayList<BoardVo>();
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>게시판</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <h1>게시물 목록</h1>");
    out.println("  <table border='1'>");
    out.println("  <tr> "
        + "<th>번호</th> <th>제목</th> <th>작성일</th> <th>조회수</th>"
        + "</tr>");
    
    for (BoardVo board : list) {
      out.println("  <tr> <td></td> <td></td> <td></td> <td></td> </tr>");
    }
    
    out.println("  </table>");
    out.println("  </body>");
    out.println("</html>");
    
  }

}










