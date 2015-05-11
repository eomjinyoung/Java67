package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.ClassroomDao;
import net.bitacademy.java67.step04.vo.ClassroomVo;
import net.bitacademy.java67.step04.vo.CrphotoVo;


@WebServlet("/step04/classrooms/list")
public class Classrooms extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		  //확장성을 위해 인터페이스 변수를 다형적으로 받음
	  
	    ClassroomDao classroomDao = new ClassroomDao();
	    classroomDao.setDBConnectionPool(new DBConnectionPool());
		  
	    List<ClassroomVo> list = classroomDao.selectList();
	    List<CrphotoVo> photoList = classroomDao.photoSelectList();
		 PrintWriter out = response.getWriter();
		 
		 
		 out.println("<html lang='en'>");
		 out.println("<head>");
		 out.println("<meta charset='utf-8'>");
		 out.println("<title>강의실 관</title>");
		 out.println("<script class='display1' src='//code.jquery.com/jquery-1.10.2.js'></script>");
		 out.println("<script class='display1' src='//code.jquery.com/ui/1.11.4/jquery-ui.js'></script>");
		 out.println("<script class='display1' src='//code.jquery.com/jquery-1.10.2.js'></script>");
		 out.println("<script class='display1' src='//code.jquery.com/ui/1.11.4/jquery-ui.js'></script>");
		 out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>");
		 out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css'>");
		 out.println("<link rel='stylesheet' href='//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css'>");
		 out.println("</head>");
		 out.println("<body id='body'>");
		 out.println("<div style='width: 900px;'>");
		 out.println("	<div class='ui-widget' align='right'>");
		 out.println("		<label for='tags'>검색 :</label>");
		 out.println("		<input id='tags'>");
		 out.println("	</div>");
		 out.println("	<div style='width: 150px; float: left;'>");
		 out.println(" 		<select id ='selLOC' class='selLOC form-control' "
		 		+ " onchange='location=\"list?LOC=\" + this.value' "
		 		+ " style='width: 130px; margin: 0px 10px'>");
		 List<String> items = new ArrayList<String>();
		 for (ClassroomVo classroom : list) {
			 items.add(classroom.getLOC());//중복제거
		 }
		 List<String> uniqueNames = new ArrayList<String>(
				 new HashSet<String>(items));
		 for (String uniqueName : uniqueNames) {
			 if(request.getParameter("LOC") != null && 
					 uniqueName.equals(request.getParameter("LOC"))) {
				 out.println("<option class='selLOC2' value='" + uniqueName 
						 + "' selected='selected'>" + uniqueName + "</option>");
			 } else {				 
				 out.println("<option class='selLOC2' value='" + uniqueName 
						 + "'>" + uniqueName + "</option>");
			 }
		 }
		 out.println("		</select><br>");
		 out.println("  		<div align='right' style='margin: 0 10px'>");
		 out.println("    		<a class='btn btn-default' "
		 		+ " href='../classroom_add.html' role='button'>추가</a><br>");
		 out.println(" 		</div>");
		 out.println("	</div>");
		 out.println("	<div id='accordion' style='float: right; width:750px'>");
		 String name = uniqueNames.get(0);
		 for (ClassroomVo classroom : list) {
			 if ((selecVal(request.getParameter("LOC")) ? false : 
				 name.equals(classroom.getLOC()) ) || 
					 classroom.getLOC().equals(request.getParameter("LOC"))) {
				 out.println("<h3 class='dataRow'>" + classroom.getROOM() + "</h3>");
				 out.println(" <div class='dataRow'>");
				 out.println("  <p>" + classroom.getCONTENT() + "</p>");
				 out.println("  <div id='photoZone" + classroom.getCNO() + "'>");
				 int photoNum = 0;
				 for (CrphotoVo photo : photoList) {
					 if(classroom.getCNO() == photo.getCno() && photoNum < 2) {
						 out.println("<img src='" + photo.getPhoto() + 
								 "alt='이미지가 없습니다.' ' style='margin: 0px 10px 0px 0px; "
								 + " height: 160px; width: 130px;'>");
						 photoNum++;
					 }
				 }
				 out.println("  </div> ");
				 out.println("  <div align='right'>");
				 out.println("  <a class='btn btn-default' href='detail?CNO=" 
						 			+ classroom.getCNO() + "'"); 
				 out.println("		   role='button'>수정</a>");
				 out.println("   <a onclick='location.href=\"delete?CNO=" 
									 + classroom.getCNO() + "&LOC=" + classroom.getLOC() 
									 + "\";' class='btn btn-default'");
				 out.println("   data-CNO='"+ classroom.getCNO() +"' role='button'>삭제</a>");
				 out.println("   <a class='btn btn-default' ");
				 out.println("   href='../crphoto/list?cno=" //사진관리 테이블에 CNO 넘기기
						 			+ classroom.getCNO() 
						 			+ "' role='button'>사진관리</a>");
				 out.println("   </div>");
				 out.println(" </div>");	 
			 }
		 } 
		 out.println("	</div>");
		 out.println("</div>");
		 out.println("<script>");
		 out.println(" $('<script>')");
		 out.println("  .html(");
		 out.println(" 		'$(function() {' +");
		 out.println("		'    $( \"#accordion\" ).accordion({' +");
		 out.println("		'      heightStyle: \"content\"    });  });' +");
		 out.println("		' $(function() {'+");
		 out.println(" 		'var availableTags = [];'+");
		 out.println("    		'for(var i = 0; i < $(); i++) {}'+");
		 out.println("   		'    $( \"#tags\" ).autocomplete({'+");
		 out.println("   		' source: availableTags });  });'");
		 out.println("     ).appendTo(body);");
		 out.println("</script>");
		 out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>");
		 out.println("</body>");
		 out.println("</html>");
	}
	
	protected boolean selecVal(String selecValue) {
        if(selecValue != null) {
           return true;
         }
        return false;
     }

}
