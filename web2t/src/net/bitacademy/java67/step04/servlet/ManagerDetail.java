package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.ManagerDao;
import net.bitacademy.java67.step04.vo.ManagerVo;

@WebServlet("/step04/manager/ManagerDetail")
public class ManagerDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    ManagerDao managerDao = new ManagerDao();
    managerDao.setDBConnectionPool(new DBConnectionPool());
    int no = Integer.parseInt(request.getParameter("no"));    
    
    ManagerVo manager = new ManagerVo();
    
   manager = managerDao.select(no);
    
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");

    out.println("</head>");
    out.println("<body>");
    out.println("<img name=\"photo\" src="+manager.getPhoto()+">");  
    out.println("<form  method=\"POST\" action=\"ManagerUpdate\">");
    out.println("<h1>매니저 상세 정보</h1>");
    out.println("<br>");




       out.println(" <label for=\"label-name\" class=\"col-sm-6 control-label\">번호</label>");
       out.println("<input  name=\"no\" value=\""+manager.getMno()+"\" >");
       out.println("<br>");
       out.println("<label for=\"label-name\" class=\"col-sm-6 control-label\">이름</label>");
       out.println("<input type=\"text\" value=\""+manager.getName()+"\" name=\"name\" >");
       out.println("<br>");
       out.println("<label for=\"label-name\" class=\"col-sm-6 control-label\">password</label>");
       out.println("<input type=\"password\" value=\""+manager.getPassword()+"\" name=\"password\" >");
       out.println("<br>");
       out.println("<label for=\"label-name\" class=\"col-sm-6 control-label\">Email</label>");
       out.println("<input type=\"text\"  value=\""+manager.getEmail()+"\" name=\"email\" >");
       out.println("<br>");
       out.println("<label for=\"label-name\" class=\"col-sm-6 control-label\">전화번호</label>");
       out.println("<input type=\"text\" value=\""+manager.getTel()+"\"  name=\"tel\" >");
       out.println("<br>");
       out.println("<label for=\"label-name\" class=\"col-sm-6 control-label\">사진</label>");
       out.println("<input type=\"text\"  value=\""+manager.getPhoto()+"\" name=\"photo\" >");
       out.println("<br>");
       out.println("<input type=\"submit\"value=\"변경\" >");       
       out.println("<button type=\"button\" onclick=\"location.href='ManagerDelete?no="+no+"'\">삭제</button>    ");
       out.println("<button type=\"button\" onclick=\"location.href='ManagerList'\">목록</button>");  
       out.println("</form>");

       out.println("</body>");
       out.println("</html>");
    
    
	}

	

}
