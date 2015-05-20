package net.bitacademy.java67.web;

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
  public String delete(int no) throws Exception {
    boardDao.delete(no);
    
    return "redirect:list.do";
  }
}













