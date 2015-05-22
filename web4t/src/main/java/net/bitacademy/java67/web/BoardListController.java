package net.bitacademy.java67.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.domain.BoardVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* 실습 목표: 스프링 애노테이션 적용 */

@Controller
public class BoardListController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("/board/list.do")
  public String list(
      @RequestParam(required=false,defaultValue="1") int pageNo, 
      @RequestParam(required=false,defaultValue="3") int pageSize, 
      @RequestParam(required=false) String word, 
      @RequestParam(required=false) String order, 
      HttpServletRequest request) throws Exception {

    int startIndex = (pageNo - 1) * pageSize;
    
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










