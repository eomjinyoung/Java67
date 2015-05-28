package net.bitacademy.java67.web.ex3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* 실습 목표: @RequestMapping의 기타 속성 사용법
 *   
 */

@Controller("ex3.PageController01") 
@RequestMapping("/ex3")
public class PageController01 {
  
  //1) GET/POST 구분하기
  //- GET 요청만 처리하기
  @RequestMapping(
      value="/test01", 
      method=RequestMethod.GET)
  public String get() {
    return "ex3/get"; 
  }
  
  //- POST 요청만 처리하기
  @RequestMapping(
      value="/test01", 
      method=RequestMethod.POST)
  public String post() {
    return "ex3/post"; 
  }
  
  //2) 지정한 요청 파라미터가 있는 요청에 대해서만 메서드를 호출한다.
  @RequestMapping(
      value="/test02",
      params={"name","age"})
  public String parameter() {
    return "ex3/parameter"; 
  }
  
  //3) 지정한 헤더가 있을 때만 메서드를 호출한다.
  @RequestMapping(
      value="/test03",
      headers="bit")
  public String header() {
    return "ex3/header"; 
  }
  
 
}





















