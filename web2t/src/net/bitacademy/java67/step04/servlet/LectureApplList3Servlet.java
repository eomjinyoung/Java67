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
import net.bitacademy.java67.step04.vo.LectureApplVo2;
import net.bitacademy.java67.step04.vo.LectureApplVo3;

/* 실습 목표: 제목에 상세보기 링크 걸기
 *          
 */
@WebServlet("/step04/lecappl/list3")
public class LectureApplList3Servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LectureApplDao lectureApplDao = new LectureApplDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    lectureApplDao.setDBConnectionPool(dbPool);
    
    //강좌 번호
    String lno = request.getParameter("lno");
    
    List<LectureApplVo3> list = lectureApplDao.lectureAppllist3();
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>게시판</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <h1>수강등록</h1>");
    out.println("  <table border='1'>");
    out.println("  <tr> "
        + "<th>학생번호</th> <th>학생이름</th>"
        + "</tr>");
    
    for (LectureApplVo3 lectureAppl : list) {
      out.println("  <tr> <td>"+ lectureAppl.getSno() + "</td> <td>"
          + "<a href='insert?sno=" + lectureAppl.getSno()  + "&lno=" + lno + "'</a>" +  lectureAppl.getName() + "</td></tr>");
    }
    
    out.println("  </table>");
    out.println("  <p><a href='list2?lno=" +lno+"'>뒤로</a></p>");
    out.println("  </body>");
    out.println("</html>");
    
  }

}










