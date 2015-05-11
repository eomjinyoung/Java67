package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.LectureApplDao;

@WebServlet("/step04/delete")
public class LectureAppDeleteServlet extends HttpServlet {
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
    //학생 번호
    String sno = request.getParameter("sno");
    
    int rs = lectureApplDao.delete(lno, sno);
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>게시판</title>");
    out.println("  </head>");
    out.println("  <body>");
    
    out.println(" <script type='text/javascript' >");
    if(rs > 0 )
    {
      out.println("alert('삭제 되었습니다.')");
    }
    else{
      out.println("alert(삭제 오류.')");
    }
    out.println("window.location = '/web2/step04/list2?lno="+lno +" ' ");
    out.println("</script>");
    
    out.println("  </body>");
    out.println("</html>");
    
  }

}










