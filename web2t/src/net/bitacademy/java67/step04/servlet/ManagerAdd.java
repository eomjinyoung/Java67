package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.ManagerDao;
import net.bitacademy.java67.step04.vo.ManagerVo;


@WebServlet("/step04/manager/ManagerAdd")
public class ManagerAdd extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    ManagerVo manager = new ManagerVo();
    manager.setName(request.getParameter("name"));
    manager.setEmail(request.getParameter("email"));
    manager.setPassword(request.getParameter("password"));
    manager.setTel(request.getParameter("tel"));
    manager.setPhoto(request.getParameter("photo"));
    
    ManagerDao managerDao = new ManagerDao();
    managerDao.setDBConnectionPool(new DBConnectionPool());
    managerDao.insert(manager);
    
    response.sendRedirect("ManagerList");
  }
}
