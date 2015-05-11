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
import net.bitacademy.java67.step04.dao.SubTraiDao;
import net.bitacademy.java67.step04.vo.SubTraiVo;

/* 실습 목표: 제목에 상세보기 링크 걸기
 *          
 */
@WebServlet("/step04/subtrai/list")
public class SubTraiListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    SubTraiDao sub_TraiDao = new SubTraiDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    sub_TraiDao.setDBConnectionPool(dbPool);

    ArrayList plist = (ArrayList)sub_TraiDao.selectList();

    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();

    List<SubTraiVo> list1 = (List)plist.get(0);
    List<SubTraiVo> list2 =(List)plist.get(1);

    out.println("<html>");
    out.println("<head>");
    out.println("  <title>강사강의과목</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1 >강사 과목 배정</h1>");

    out.println("<div id ='teachers' class='centered'> ");
    for(SubTraiVo sub_Trai1 : list1) {
      out.println("<br><tr><td>"+sub_Trai1.tno+"  </td><td>"+sub_Trai1.name+"</td><br>");
      out.println("<td><img src='images/"+sub_Trai1.photo+"' "
          + " onclick='cc();' width='200px'/><td>");
      for(SubTraiVo sub_Trai2 : list2) {
        if(sub_Trai2.tno == sub_Trai1.tno) {
          out.println("<tr>"+sub_Trai2.title+"</tr>");
        }
      }
      out.println("<td><a href='detail?no="+ sub_Trai1.tno+ "'>"
          +"변경하기 </a>");
    }
    out.println("  </body>");
    out.println("</html>");




  }

}










