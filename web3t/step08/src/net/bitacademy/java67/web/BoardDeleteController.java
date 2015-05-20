package net.bitacademy.java67.web;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.java67.annotation.Component;
import net.bitacademy.java67.annotation.RequestMapping;
import net.bitacademy.java67.dao.BoardDao;

/* 실습 목표: 애노테이션 적용
 */
@Component("/board/delete.do")
public class BoardDeleteController {
  //의존 객체 주입을 위한 변수와 셋터 선언
  BoardDao boardDao;
  
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @RequestMapping
  public String delete(HttpServletRequest request) throws Exception {
    boardDao.delete(Integer.parseInt(request.getParameter("no")));
    
    return "redirect:list.do";
  }
}













