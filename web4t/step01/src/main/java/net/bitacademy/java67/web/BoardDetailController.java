package net.bitacademy.java67.web;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.java67.annotation.Component;
import net.bitacademy.java67.annotation.RequestMapping;
import net.bitacademy.java67.dao.BoardDao;

/* 실습 목표: 애노테이션 적용
 */
@Component("/board/detail.do")
public class BoardDetailController {
  // 의존 객체를 주입할 수 있도록 변수와 셋터 메서드를 선언한다.
  BoardDao boardDao;
  
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @RequestMapping
  public String detail(int no, HttpServletRequest request) throws Exception {
    request.setAttribute("board", boardDao.select(no));
    
    return "/board/BoardDetail.jsp";
  }
}













