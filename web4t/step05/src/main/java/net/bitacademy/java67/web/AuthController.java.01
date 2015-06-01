package net.bitacademy.java67.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthController {

  @RequestMapping(value="/login",method=RequestMethod.GET)
  public void loginForm() {
    // view URL 주소를 리턴하지 않으면,
    // 요청 URL을 리턴한다.
    // 요청 URL? 
    // 만약 클라이이언트가 요청한 전체 URL이 다음과 같다면,
    // http://localhost:9999/web4t/auth/login.do
    // => 웹 애플리케이션 주소까지 제외한다. => auth/login.do
    // => 접미사를 제외한다. => auth/login
    // => 따라서 요청 URL은 "auth/login"이 된다.
    // 
    // InternalResouceViewResolver가 요청 URL을 받아서 실제 JSP URL을 만들면,
    // => /WEB-INF/views/auth/login.jsp
    
    // 결론, 같은 경로에 요청 URL의 이름과 같은 JSP 파일을 만들면,
    // 굳이 JSP URL을 리턴하지 않아도 된다.
    
  }
  
  @RequestMapping(value="/login",method=RequestMethod.POST)
  public String login() {
    return "redirect:../board/list.do";
  }
}












