package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.ManagerDao;
import net.bitacademy.java67.step04.vo.ManagerVo;

@WebServlet("/step04/manager/ManagerList")
public class ManagerList extends HttpServlet {
  private static final long serialVersionUID = 1L;
  

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    ManagerDao managerDao = new ManagerDao();
    managerDao.setDBConnectionPool(new DBConnectionPool());
    List<ManagerVo> list = new ArrayList<ManagerVo>();    
    list = managerDao.selectList();
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물 목록</h1>");
    out.println("<table border='1'>");
    out.println(" <tr>");
    out.println("<th>번호</th>");
    out.println("<th>이름</th>");
    out.println("<th>전화번호</th>");
    
    out.println("</tr>");
 for (ManagerVo manager : list) {
      out.println("<tr>");
      out.println("<td>"+manager.getMno()+"</td>");
      out.println("<td><a href=ManagerDetail?no="+manager.getMno()+">"+manager.getName()+"</a></td>");
      out.println("<td>"+manager.getTel()+"</td>");
      out.println("</tr>");
    }
   out.println("</table>");
    out.println("<p><a href='add.html'> 새 글</a></p>");
    out.println("</body>");
    out.println("</html>");

   
    
    
    
    
  }
}