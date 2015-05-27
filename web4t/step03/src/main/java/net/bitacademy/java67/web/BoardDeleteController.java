package net.bitacademy.java67.web;

import net.bitacademy.java67.dao.BoardDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 실습 목표: 스프링 애노테이션 적용 */

@Controller
public class BoardDeleteController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("/board/delete.do")
  public String delete(int no) throws Exception {
    boardDao.delete(no);
    
    return "redirect:list.do";
  }
}













