package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.ClassroomDao;
import net.bitacademy.java67.step04.vo.ClassroomVo;

@WebServlet("/step04/classrooms/add")
public class ClassroomAddServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ClassroomVo classroomVo = new ClassroomVo();
		classroomVo.setLOC(request.getParameter("LOC"));
		classroomVo.setROOM(request.getParameter("ROOM"));
		classroomVo.setCONTENT(request.getParameter("CONTENT"));
		
		ClassroomDao classroomDao = new ClassroomDao();
		classroomDao.setDBConnectionPool(new DBConnectionPool());
		classroomDao.insert(classroomVo);
		
		response.sendRedirect("list");
	}
}
