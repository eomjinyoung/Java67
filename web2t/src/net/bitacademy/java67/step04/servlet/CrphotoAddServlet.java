package net.bitacademy.java67.step04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.CrphotoDao;

/* 실습 목표: 게시물 등록후 목록 화면으로 이동하기3
 *          단, 등록 성공 결과 화면을 출력하지 말고 바로 목록 화면으로 이동하라. 
 * 
 */

@WebServlet("/step04/crphoto/add")
public class CrphotoAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    String photo = request.getParameter("photo");
    int cno = Integer.parseInt(request.getParameter("cno"));
    
    CrphotoDao crphotoDao = new CrphotoDao();
    crphotoDao.setDBConnectionPool(new DBConnectionPool());
    crphotoDao.insert(photo,cno);
    
    response.sendRedirect("list?cno="+cno);
    
  }
}










