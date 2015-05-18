package net.bitacademy.java67.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.domain.BoardVo;

/* 실습 목표: 페이지 컨트롤러 작성
 */

public class BoardListController implements Controller {
  // BoardListController가 작업을 수행하기 위해 사용할 객체 선언
  // => Dependency Object: 의존(하는) 객체
  BoardDao boardDao;
  
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public String execute(HttpServletRequest request) throws Exception {
    int startIndex = 0;
    int pageSize = 3;
    int pageNo = 1;
        
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }

    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
      startIndex = (pageNo - 1) * pageSize;
    }
    
    String word = request.getParameter("word");
    
    String order = request.getParameter("order");
    
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










