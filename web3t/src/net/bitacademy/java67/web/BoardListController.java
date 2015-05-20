package net.bitacademy.java67.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.java67.annotation.Component;
import net.bitacademy.java67.annotation.RequestMapping;
import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.domain.BoardVo;

/* 실습 목표: 애노테이션 적용
 */
@Component("/board/list.do")
public class BoardListController {
  // BoardListController가 작업을 수행하기 위해 사용할 객체 선언
  // => Dependency Object: 의존(하는) 객체
  BoardDao boardDao;
  
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping
  public String list(int pageNo, int pageSize, 
      String word, String order, 
      HttpServletRequest request) throws Exception {

    int startIndex = 0;
    if (pageSize == 0) {
      pageSize = 3;
    }

    if (pageNo == 0) {
      pageNo = 1;
    }
    startIndex = (pageNo - 1) * pageSize;
    
    //JSP가 화면을 준비할 때 사용할 값을 ServletRequest에 담는다.
    List<BoardVo> list = boardDao.selectList(
                              startIndex, pageSize, word, order);
    request.setAttribute("list", list);
    request.setAttribute("pageNo", pageNo);
    request.setAttribute("pageSize", pageSize);
    
    //총 페이지 수 구하기
    int countAll = boardDao.countAll(word);
    int maxPage = countAll / pageSize;
    if (countAll % pageSize > 0) {
      maxPage++;
    }
    request.setAttribute("maxPage", maxPage);
    
    return "/board/BoardList.jsp";
  }

}










