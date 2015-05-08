package net.bitacademy.java67.step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: HttpServlet 클래스 사용 전
 */
//@WebServlet("/step03/list")
public class BoardListServlet01 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
    // HTTP 기능을 완전하게 사용하기 위해 원래 타입으로 형변환 한다.
    HttpServletRequest request = (HttpServletRequest) arg0;
    HttpServletResponse response = (HttpServletResponse) arg1;
    
    
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










