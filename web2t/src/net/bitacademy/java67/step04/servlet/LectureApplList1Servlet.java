package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.LectureApplDao;
import net.bitacademy.java67.step04.vo.LectureApplVo1;
import net.bitacademy.java67.step04.vo.LectureApplVo1;

/* 실습 목표: 제목에 상세보기 링크 걸기
 *          
 */
@WebServlet("/step04/lecappl/list1")
public class LectureApplList1Servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LectureApplDao lectureApplDao = new LectureApplDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    lectureApplDao.setDBConnectionPool(dbPool);
    
    List<LectureApplVo1> list = lectureApplDao.lectureAppllist1();
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>게시판</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <h1>강의 목록</h1>");
    out.println("  <table border='1'>");
    out.println("  <tr> "
        + "<th>번호</th> <th>제목</th>"
        + "</tr>");
    
    for (LectureApplVo1 lectureAppl : list) {
      out.println("  <tr> <td>"
          + lectureAppl.getLno() + "</td> <td><a href='list2?lno="+ lectureAppl.getLno() + "'>"
          + lectureAppl.getTitle() + "</a></td></tr>");
    }
    
    out.println("  </table>");
    out.println("  </body>");
    out.println("</html>");
    
  }

}










