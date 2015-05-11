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
import net.bitacademy.java67.step04.dao.SubjectDao;
import net.bitacademy.java67.step04.vo.SubjectVo;

/* 실습 목표: 제목에 상세보기 링크 걸기
 *          
 */
@WebServlet("/step04/subject/list")
public class SubjectListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    SubjectDao subjectDao = new SubjectDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    subjectDao.setDBConnectionPool(dbPool);
    
    List<SubjectVo> list = subjectDao.selectList();
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>강의목록</title>");
    out.println("		<script type='text/javascript' src='subject/subject.js'></script>");
    
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <h1>강의목록</h1>");
    out.println("  <p><a href='form.html'>새 강의 등록</a></p>");
    out.println("  <table border='1'>");
    out.println("  <tr> "
        + "<th>번호</th> <th>강의명</th>"
        + "</tr>");
    
    for (SubjectVo subject : list) {
      out.println("  <tr> <td>"
          + subject.getNo() + "</td> <td><a href='detail?no="+ subject.getNo() +"'>"
          + subject.getTitle() + "</a></td></tr>");
    }
    
    out.println("  </table>");
    out.println("  </body>");
    out.println("</html>");
    
  }

}










