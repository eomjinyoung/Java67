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

@WebServlet("/step04/manager/ManagerUpdate")
public class ManagerUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;
  

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    ManagerDao managerDao = new ManagerDao();
    managerDao.setDBConnectionPool(new DBConnectionPool());
    
    
    ManagerVo manager = new ManagerVo();
    manager.setMno(Integer.parseInt(request.getParameter("no")));
    manager.setName(request.getParameter("name"));
    manager.setEmail(request.getParameter("email"));
    manager.setPassword(request.getParameter("password"));
    manager.setPhoto(request.getParameter("photo"));
    manager.setTel(request.getParameter("tel"));
    managerDao.update(manager);
   
    response.sendRedirect("ManagerList");
   
    
    
    
    
  }
}