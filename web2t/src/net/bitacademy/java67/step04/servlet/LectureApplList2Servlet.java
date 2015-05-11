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
import net.bitacademy.java67.step04.vo.LectureApplVo2;

/* 실습 목표: 제목에 상세보기 링크 걸기
 *          
 */
@WebServlet("/step04/lecappl/list2")
public class LectureApplList2Servlet extends HttpServlet {
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
    
    List<LectureApplVo2> list = lectureApplDao.lectureAppllist2(lno);
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>게시판</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <h1>수강 현황</h1>");
    out.println("  <table border='1'>");
    out.println("  <tr> "
        + "<th>학생번호</th> <th>학생이름</th> <th>신청날짜</th> <th>신청결과</th> <th>신청취소</th>"
        + "</tr>");
    
    for (LectureApplVo2 lectureAppl : list) {
      out.println("  <tr> <td>"
          + lectureAppl.getSno() + "</td> <td>" 
          + lectureAppl.getName() + "</td> <td>" 
          + lectureAppl.getAp_date() + "</td> <td>" 
          + lectureAppl.getState() + "</td><td>"
          + "<a href='delete?lno=" + lno +  "&sno=" +  lectureAppl.getSno() + "' >" +"취소</a></td></tr>"
          );
    }
    
    out.println("  </table>");
    out.println("  <p><a href='list3?lno="+ lno  +"'>수강신청</a></p>");
    out.println("  <p><a href='list1'>홈으로</a></p>");
    out.println("  </body>");
    out.println("</html>");
    
  }

}










