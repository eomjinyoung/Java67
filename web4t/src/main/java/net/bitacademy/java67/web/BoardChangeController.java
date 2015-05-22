package net.bitacademy.java67.web;

import net.bitacademy.java67.annotation.Component;
import net.bitacademy.java67.annotation.RequestMapping;
import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.domain.BoardVo;

/* 실습 목표: 애노테이션 적용
 */
@Component("/board/change.do")
public class BoardChangeController {
  // 의존 객체를 주입하기 위한 변수와 셋터 선언
  BoardDao boardDao;
  
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @RequestMapping
  public String change(BoardVo board) throws Exception {
    boardDao.update(board);
    
    return "redirect:list.do";
  }
}













