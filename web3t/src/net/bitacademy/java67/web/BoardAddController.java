package net.bitacademy.java67.web;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.java67.annotation.Component;
import net.bitacademy.java67.annotation.RequestMapping;
import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.domain.BoardVo;

/* 실습 목표: 애노테이션 적용
 */
@Component("/board/add.do") 
public class BoardAddController {
  //의존 객체 주입을 위한 변수와 셋터 선언
  BoardDao boardDao;
  
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @RequestMapping
  public String add(HttpServletRequest request) throws Exception {
    BoardVo board = new BoardVo();
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    
    boardDao.insert(board);
    
    return "redirect:list.do";
  }
}










