package net.bitacademy.java67.web;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.java67.dao.BoardDao;

/* 실습 목표: 페이지 컨트롤러 작성
 */
public class BoardDetailController implements Controller {
  // 의존 객체를 주입할 수 있도록 변수와 셋터 메서드를 선언한다.
  BoardDao boardDao;
  
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @Override
  public String execute(HttpServletRequest request) throws Exception {
    request.setAttribute("board", boardDao.select(
            Integer.parseInt(request.getParameter("no"))));
    
    return "/board/BoardDetail.jsp";
  }
}













