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
import net.bitacademy.java67.step04.dao.StudentDao;
import net.bitacademy.java67.step04.vo.StudentVo;

@WebServlet("/step04/student/search")
public class StudentSearchServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    String name = "%" + request.getParameter("search") + "%";

    StudentDao studentDao = new StudentDao();
    studentDao.setDBConnectionPool(new DBConnectionPool());
    
    List<StudentVo> list = studentDao.search(name);

    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>학생 리스트</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <h1>학생 목록</h1>");
    out.println("  <p><a href='form.html'>학생 등록</a></p>");
    out.println("  <form action='search' method='POST'");
    out.println("   <div class='input-group'>");
    out.println("    <input type='search' name='search' placeholder='학생명 검색' onkeypress='if(event.keyCode==13) {enterBtn(); return false;}' autofocus>");
    out.println("       <span class='input-group-btn'>");
    out.println("         <input type='submit' value='검색'>");
    out.println("        </span>");
    out.println("      </div>");
    out.println("    </form>");
    out.println("  <table border='1'>");
    out.println("  <tr> "
        + "<th>번호</th> <th>학생이름</th>"
        + "</tr>");
    
    for (StudentVo student : list) {
      out.println("  <tr> <td>"
          + student.getSno() + "</td> <td><a href='detail?no=" 
          + student.getSno() + "'>"
          + student.getName() + "</a></td> </tr>");
    }
    
    out.println("  </table><br>");
    out.println("<input type='button' value='전체목록' onclick=\"location.href='list';\">");
    out.println("  </body>");
    out.println("</html>");
  }
}
