package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.CrphotoDao;
import net.bitacademy.java67.step04.vo.CrphotoVo;

/* 실습 목표: 제목에 상세보기 링크 걸기
 *          
 */
@WebServlet("/step04/crphoto/list")
public class CrphotoListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    CrphotoDao crphotoDao = new CrphotoDao();
    DBConnectionPool dbPool = new DBConnectionPool();
    crphotoDao.setDBConnectionPool(dbPool);
    
    int cno = Integer.parseInt(request.getParameter("cno"));
    
    CrphotoVo loc = crphotoDao.loc(cno);
    List<CrphotoVo> list = crphotoDao.selectList(cno);

    CrphotoVo count = crphotoDao.count(cno);
    int countvalue = count.getCount();
    System.out.println(cno);
    
    response.setContentType("text/html;charset=UTF-8");
    
    
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>강의실 사진</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <h1>강의실 사진</h1>");
    out.println("  <h2>"+loc.getLoc()+" "+loc.getRoom()+"호</h2>");
    
    if(countvalue==0) {
    out.println("<h3>사진이 없습니다. 추가해주세요 <h3>");
    } else {
    
    for (CrphotoVo crphoto : list) {
      out.println("  <a href='detail?cpno=" 
          + crphoto.getCpno() + "'><img src=\""
          + crphoto.getPhoto() + "\"></a>"); 
    }
    }
    out.println("<script>");
    out.println("function test() {var inputurl=prompt('사진 url을 입력하세요.');location.href= \"add?cno="+ cno + "&photo=\"+inputurl}");
    out.println("</script>");
    out.println("<button id=\"addBtn\" type=\"button\" onclick = \"location.href='javascript:test();'\">등록</button>");
    out.println("  </body>");
    out.println("</html>");
    
  }

}










