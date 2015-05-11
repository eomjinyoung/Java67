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
import net.bitacademy.java67.step04.dao.TeacherDao;
import net.bitacademy.java67.step04.vo.TeacherVo;

/* 실습 목표: 제목에 상세보기 링크 걸기
 *          
 */
@WebServlet("/step04/teacherSearch")
public class TeacherSearchListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    TeacherDao teacherDao = new TeacherDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    teacherDao.setDBConnectionPool(dbPool);
    String colum = request.getParameter("colum");
    String value = request.getParameter("value");
    List<TeacherVo> list = teacherDao.searchList(colum,value);
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>강사 정보</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("<h1>검색 결과</h1>");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("  <th>강사번호</th>");
    out.println("  <th>강사명</th>");
    out.println("  <th>전화번호</th>");
    out.println("  <th>시급</th>");
    out.println("</tr>");
    for (TeacherVo teacher : list) {
        out.println("  <tr> <td>"
            + teacher.getTno() + "</td> <td><a href='teacherDetail?tno=" 
            + teacher.getTno() + "'>"
            + teacher.getName() + "</a></td> <td>"
            + teacher.getTel() + "</td> <td>"
            + teacher.getWage() + "</td> </tr>");
      }
      
    out.println("</table>");
    out.println("<input type='button' value='목록으로' onclick=\"location.href='teacherList';\">");
    out.println("  </body>");
    out.println("</html>");
    
  }

}










