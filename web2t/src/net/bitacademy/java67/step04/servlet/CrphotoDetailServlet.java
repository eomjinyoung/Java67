package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.CrphotoDao;
import net.bitacademy.java67.step04.vo.CrphotoVo;

/* 실습 목표: doGet(), doPost() 사용하기
 * - HttpServlet 클래스는 내부적으로 GET, POST, PUT, DELETE 등의 
 *   클라이언트의 요청 방법에 따라 호출될 메서드를 정의하고 있다.
 *   doXXX() 메서드이다.
 */

@WebServlet("/step04/crphoto/detail")
public class CrphotoDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
       
    CrphotoDao crphotoDao = new CrphotoDao();
    crphotoDao.setDBConnectionPool(new DBConnectionPool());
    CrphotoVo crphoto = crphotoDao.select(
        Integer.parseInt(request.getParameter("cpno")));
    
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>강의실 사진</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <h1>강의실 사진</h1>");
    out.println("<form action=\"delete\" method=\"get\">");
    out.println("  <img src=\""
          + crphoto.getPhoto() + "\"></a>");
    
    out.println("<input type='button' value='삭제'"
        + " onclick=\"location.href='delete?cno="+ crphoto.getCno() + "&cpno=" + crphoto.getCpno() + "'\">");
    out.println("<input type='button' value='취소' onclick=\"location.href='list?cno="+ crphoto.getCno() +"';\">");
    out.println("</form>");

    out.println("  </body>");
    out.println("</html>");
  }
}













