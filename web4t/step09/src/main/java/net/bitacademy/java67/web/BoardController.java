package net.bitacademy.java67.web;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.java67.domain.BoardVo;
import net.bitacademy.java67.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired
  BoardService boardService;
  
  @RequestMapping("/list")
  public String list(
      @RequestParam(required=false,defaultValue="1") int pageNo, 
      @RequestParam(required=false,defaultValue="3") int pageSize, 
      @RequestParam(required=false) String word, 
      @RequestParam(required=false) String order, 
      Model model) throws Exception {

    model.addAttribute("list", boardService.list(
        getStartIndexOfPage(pageNo, pageSize), pageSize, word, order));
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("maxPage", countTotalPage(
                                    pageSize, boardService.size(word)));
    
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
  public String add(BoardVo board, HttpServletRequest request) throws Exception {
    boardService.add(board, request.getRemoteAddr());
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/change")
  public String change(BoardVo board, HttpServletRequest request) throws Exception {
    boardService.change(board, request.getRemoteAddr());
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/delete")
  public String delete(int no, HttpServletRequest request) throws Exception {
    boardService.remove(no, request.getRemoteAddr());
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/detail")
  public String detail(int no, Model model) throws Exception {
    model.addAttribute("board", boardService.get(no));
    
    return "board/BoardDetail";
  }

}










