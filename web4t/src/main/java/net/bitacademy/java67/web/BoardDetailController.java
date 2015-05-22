package net.bitacademy.java67.web;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.java67.dao.BoardDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 실습 목표: 스프링 애노테이션 적용 */

@Controller
public class BoardDetailController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("/board/detail.do")
  public String detail(int no, HttpServletRequest request) throws Exception {
    request.setAttribute("board", boardDao.select(no));
    
    return "/board/BoardDetail.jsp";
  }
}













