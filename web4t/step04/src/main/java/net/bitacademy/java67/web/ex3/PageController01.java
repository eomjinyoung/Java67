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
  
  //4) Accept 요청 헤더가 지정된 값을 가질 때만 호출한다.
  // - 서버 입장에서 클라이언트에게 보낼 데이터를 생성한다는 의미로 produces이다.
  @RequestMapping(
      value="/test04",
      produces="text/csv")
  public String produces() {
    return "ex3/produces"; 
  }
  
  //5) Context-Type 요청 헤더가 지정된 값을 가질 때만 호출한다.
  // - 클라이언트는 POST 방식으로 데이터를 보낼 때 
  //   Content-Type 헤더 값으로 보내는 콘텐츠의 형식을 알려준다. 
  // - 서버 입장에서 클라이언트가 보낸 데이터를 소비한다는 의미로 consumes이다.
  @RequestMapping(
      value="/test05",
      consumes="text/csv")
  public String consumes() {
    return "ex3/consumes"; 
  }
}





















