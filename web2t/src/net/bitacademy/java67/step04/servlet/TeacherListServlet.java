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
@WebServlet("/step04/teacherList")
public class TeacherListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    TeacherDao teacherDao = new TeacherDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    teacherDao.setDBConnectionPool(dbPool);
    
    List<TeacherVo> list = teacherDao.selectList();
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>강사 정보</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("<h1>강사 목록</h1>");
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
      
    out.println("<button  type='button' onclick=\"location.href='teacherAForm';\">강사 등록</button>");
    out.println("</table>");
    out.println("<form action='teacherSearch'>");
    out.println("<select name = colum>");
    out.println("  <option value='name'>강사명</option>");
    out.println("  <option value='tno'>강사번호</option>");
    out.println("  <option value='tel'>전화번호</option>");
    out.println("</select>");
    out.println("<input  id= 'searchBox' type='text' name='value' size='20'>");
    out.println("<button>검색</button>");
    out.println("</form>");
    out.println("  </body>");
    out.println("</html>");
    
  }

}










