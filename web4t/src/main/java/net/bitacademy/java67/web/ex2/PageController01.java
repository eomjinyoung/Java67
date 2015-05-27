package net.bitacademy.java67.web.ex2;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/* 실습 목표: request handler의 다양한 리턴 값 
 *   
 */

//@Controller // 빈의 이름을 지정하지 않으면 클래스 이름(첫 알파벳은 소문자)을 사용한다.
            // ex1 패키지에 선언된 PageController01과 이름 충돌이 발생한다.
@Controller("ex2.PageController01") // 따라서 클래스 이름이 같은 다른 페이지 컨트롤러와
                                    // 충돌하지 않으면 명확히 빈의 이름을 지정해야 한다.
@RequestMapping("/ex2")
public class PageController01 {
  
  //1) view URL 리턴하기
  @RequestMapping("/test01")
  public String test01() {
    return "/ex2/test01.jsp"; 
  }
  
  //2) ModelAndView 객체에 view URL 정보를 담아서 리턴하기
  @RequestMapping("/test02")
  public ModelAndView test02() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/ex2/test02.jsp");
    return mv; 
  }
  
  //3) ModelAndView 객체에 JSP가 사용할 데이터를 담아서 리턴한다.
  @RequestMapping("/test03")
  public ModelAndView test03() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/ex2/test03.jsp");
    mv.addObject("name", "홍길동");
    mv.addObject("age", 30);
    // ModelAndView 객체에 보관된 데이터는
    // 프론트 컨트롤러에 의해 ServletRequest로 옮겨진다.
    // 따라서 JSP는 EL를 사용하여 가볍게 꺼낼 수 있다.
    
    return mv; 
  }
  
  //4) 페이지 컨트롤러에서 클라이언트로 보낼 콘텐츠를 바로 리턴하기
  //   리턴 값이 view URL이 아니라 콘텐츠임을 프론트 컨트롤러에게 알려줘야 한다.
  //   문제점: 콘텐츠를 내보낼 때 UTF-8로 변환할 수 없다.
  //         기본적으로 ISO-8859-1로 보낸다. => 한글 깨짐!
  @RequestMapping("/test04")
  @ResponseBody // 프론트 컨트롤러야! 리턴 값이 콘텐트이다. 그대로 클라이언트에게 보내라!
  public String test04() {
    return "<html><body><h1>안녕!!</h1></body></html>"; 
  }
  
  //5) 클라이언트에 보낼 콘텐츠를 ResponseEntity에 담아서 리턴한다.
  //   리턴 타입이 ResponseEntity 이기 때문에,
  //   @ResponsBody 애노테이션을 붙일 필요가 없다.
  @RequestMapping("/test05")
  public ResponseEntity<String> test05() {
    // 응답 헤더를 준비한다. 특히 클라이언트에 보낼 콘텐츠의 타입 정보를 설정한다.
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/html;charset=UTF-8");
    
    // 응답할 콘텐츠와 헤더정보, 응답 상태 정보를 ResponseEntity에 담아서 리턴한다.
    return new ResponseEntity<String>(
              "<html><body><h1>안녕!!</h1></body></html>", // 콘텐츠
              headers, // 응답 헤더
              HttpStatus.OK // 응답 상태 코드. 200을 의미한다. 
            );
    
  }
  
  
  
  
}





















