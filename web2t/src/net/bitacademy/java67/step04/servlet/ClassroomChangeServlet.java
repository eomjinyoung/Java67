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

//실습 목표 : Get 요청에 대해서만 응답하게 하자

@WebServlet("/step04/classrooms/change")
public class ClassroomChangeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");

		ClassroomDao classroomDao = new ClassroomDao();
		classroomDao.setDBConnectionPool(new DBConnectionPool());
	    ClassroomVo classroomVo = new ClassroomVo();
	    classroomVo.setCNO(Integer.parseInt(request.getParameter("CNO")));
	    classroomVo.setLOC(request.getParameter("LOC"));
	    classroomVo.setCONTENT(request.getParameter("CONTENT"));
	    classroomVo.setROOM(request.getParameter("ROOM"));
	    classroomDao.update(classroomVo);
	    
	    response.sendRedirect("list");
	}
}
