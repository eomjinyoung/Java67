package net.bitacademy.java67.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 게시물 등록후 목록 화면으로 이동하기3
 *          단, 등록 성공 결과 화면을 출력하지 말고 바로 목록 화면으로 이동하라. 
 * - 
 */

@WebServlet("/step03/add")
public class BoardAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    BoardVo board = new BoardVo();
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    
    BoardDao boardDao = new BoardDao();
    boardDao.setDBConnectionPool(new DBConnectionPool());
    boardDao.insert(board);
    
    response.sendRedirect("list");
    
    // 리다이렉트는 서버에서 클라이언트로 응답할 때 본문을 보내지 않는다.
    // 따라서 다음의 출력은 무시된다.
    //
    // 이미 출력했는데 어떻게 클라이언트로 보내지 않나요?
    // 보낸 것을 취소하는 기능이 있나요?
    // 
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>게시판</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <p>등록 성공입니다.</p>");
    out.println("  </body>");
    out.println("</html>");
  }
}












