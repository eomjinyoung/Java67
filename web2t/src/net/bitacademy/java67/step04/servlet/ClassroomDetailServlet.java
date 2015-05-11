package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.ClassroomDao;
import net.bitacademy.java67.step04.vo.ClassroomVo;

//실습 목표 : Get 요청에 대해서만 응답하게 하자

@WebServlet("/step04/classrooms/detail")
public class ClassroomDetailServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		ClassroomDao classroomDao = new ClassroomDao();
		classroomDao.setDBConnectionPool(new DBConnectionPool());
	    ClassroomVo classroomVo = classroomDao.select(
	        Integer.parseInt(request.getParameter("CNO")));
		
	    out.println("<html lang='en'>");
	    out.println("<head>");
	    out.println("<meta charset='utf-8'>");
	    out.println("<title>강의실 관</title>");
	    out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>");
	    out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css'>");
	    out.println("<link rel='stylesheet' href='//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css'>");
	    out.println("<link rel='stylesheet' href='/resources/demos/style.css'>");
	    out.println("<script src='//code.jquery.com/jquery-1.10.2.js'></script>");
	    out.println("<script src='//code.jquery.com/ui/1.11.4/jquery-ui.js'></script>");
	    out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>");
	    out.println("</head>");
	    out.println("<body style='width: 500px; margin: 20px 40px'>");
	    out.println("<div>");
	    out.println("<h1 align='center'>수정</h1>");
	    out.println("<div>  ");
	    out.println("<form action='change?CNO=" + classroomVo.getCNO() 
	    		+ "' method='post'>");
	    out.println("<fieldset class='form-inline' >");
	    out.println(" <div class='form-group' style='width: 269px;'>");
	    out.println("<label for='exampleInputName2'>장소</label>");
	    out.println("<input name='LOC' type='text' class='form-control' "
	    		+ " id='LOC' value='" + classroomVo.getLOC() + "' placeholder='장소'>");
	    out.println("</div>");
	    out.println("<div class='form-group'>");
	    out.println("<label for='exampleInputEmail2'>호실</label>");
	    out.println(" <input name='ROOM' type='text' class='form-control' "
	    		+ " id='ROOM' value='" + classroomVo.getROOM() 
	    		+ "' placeholder='XX 호실'>");
	    out.println("</div>");
	    out.println("</fieldset>");
	    out.println("<fieldset>");
	    out.println("<div style='margin: 15px 0 0 0;'>");
	    out.println("<label for='exampleInputName2'>장소</label> ");
	    out.println("<textarea name='CONTENT' class='form-control' "
	    		+ " rows='8' id='CONTENT'>" + classroomVo.getCONTENT() 
	    		+ "</textarea>");
	    out.println("</div>");
	    out.println(" <div align='right'>");
	    out.println("<button id = 'addBtn' type='submit' "
	    		+ " class='btn btn-default' style='margin: 10px'>완료</button>");
	    out.println("<a id = 'cancleBtn' onclick=\"location.href='list';\" ");
	    out.println(" 	class='btn btn-default' role='button' "
	    		+ " style='margin: 10px'>취소</a>");     
	    out.println(" </div>");
	    out.println("</fieldset>");
	    out.println("</form>");
	    out.println("</div>");
	    out.println("</div>");
	    out.println("</body>");
	    out.println("</html>");
	}
}
