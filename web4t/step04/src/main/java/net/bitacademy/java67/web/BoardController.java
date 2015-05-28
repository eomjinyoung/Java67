package net.bitacademy.java67.web;

import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.domain.BoardVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* 실습 목표: CRUD 기능을 한 클래스에 넣기 */

@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("/list")
  public String list(
      @RequestParam(required=false,defaultValue="1") int pageNo, 
      @RequestParam(required=false,defaultValue="3") int pageSize, 
      @RequestParam(required=false) String word, 
      @RequestParam(required=false) String order, 
      Model model) throws Exception {

    model.addAttribute("list", boardDao.selectList(
              getStartIndexOfPage(pageNo, pageSize), 
              pageSize, word, order));
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("maxPage", countTotalPage(pageSize, 
                                     boardDao.countAll(word)));
    
    return "board/BoardList";
  }

  private int getStartIndexOfPage(int pageNo, int pageSize) {
    return (pageNo - 1) * pageSize;
  }

  private int countTotalPage(int pageSize, int totalRecords) {
    int maxPage = totalRecords / pageSize;
    if (totalRecords % pageSize > 0) {
      maxPage++;
    }
    return maxPage;
  }
  
  @RequestMapping("/add")
  public String add(BoardVo board) throws Exception {
    boardDao.insert(board);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/change")
  public String change(BoardVo board) throws Exception {
    boardDao.update(board);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/delete")
  public String delete(int no) throws Exception {
    boardDao.delete(no);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/detail")
  public String detail(int no, Model model) throws Exception {
    model.addAttribute("board", boardDao.select(no));
    
    return "board/BoardDetail";
  }

}










