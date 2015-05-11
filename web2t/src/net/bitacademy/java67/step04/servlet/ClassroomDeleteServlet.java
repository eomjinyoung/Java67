package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.ClassroomDao;


@WebServlet("/step04/classrooms/delete")
public class ClassroomDeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ClassroomDao classroomDao = new ClassroomDao();
		classroomDao.setDBConnectionPool(new DBConnectionPool());
		classroomDao.delete(Integer.parseInt(request.getParameter("CNO")));
		String LOC = request.getParameter("LOC");
		response.setContentType("text/html;charset=UTF-8");
		//response.sendRedirect("classrooms?LOC=강남"); ???
		response.sendRedirect("list");

		
	}
}
