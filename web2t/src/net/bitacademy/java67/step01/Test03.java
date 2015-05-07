package net.bitacademy.java67.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 실습 목표: 클라이언트로 출력하기

//@WebServlet(urlPatterns="/step01/Test03")
// 배치 정보를 설정할 때 URL 패턴만 지정한다면, 
// 다음과 같이 속성 이름 urlPatterns를 생략할 수 있다.
@WebServlet("/step01/Test03")
public class Test03 extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    //응답 헤더에 Content-type을 설정한다.
    //반드시 출력 스트림을 얻기 전에 컨텐츠 타입을 설정해야 한다.
    //출력 스트림을 얻은 후에 설정하면 무시된다.
    response.setContentType("text/plain;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("Hello");
    out.println("안녕");
  }
}



















