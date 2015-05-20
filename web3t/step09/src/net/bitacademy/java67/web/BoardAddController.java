package net.bitacademy.java67.web;

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
  public String add(BoardVo board) throws Exception {
    boardDao.insert(board);
    
    return "redirect:list.do";
  }
}










