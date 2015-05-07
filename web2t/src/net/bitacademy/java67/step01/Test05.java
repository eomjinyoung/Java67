package net.bitacademy.java67.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
/*
  실습 목표: 파라미터 값 꺼내기
 */
@WebServlet("/step01/Test05")
public class Test05 extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    //파라미터 값 꺼내기
    // 1) GET 요청 파라미터 값
    //    => 톰캣 8 버전부터 : 특별한 처리없이 한글 파라미터 값이 유니코드로 제대로 변환된다. 
    //    => 톰캣 7 이하 버전:
    //          한글 값이 ISO-8859-1(영어)로 간주된다. 유니코드로 변환될 때 깨진다.
    //       해결책: 톰캣 설정파일(server.xml)에서 다음과 같이 URIEncoding 속성을 추가하라
    //      <Connector connectionTimeout="20000" 
    //                   port="9999" 
    //                   protocol="HTTP/1.1" 
    //                   redirectPort="8443"
    //                   URIEncoding="UTF-8"/>
    // 2) POST 요청 파라미터 값
    //    => POST 요청으로 넘어오는 파라미터 값을 꺼내기 전에 어떤 문자 집합으로
    //       인코딩 했는지 알려줘야 한다.
    //       알려주지 않으면, 영어라고 간주하고 유니코드로 바꾼다.
    //    => AB가각(EUC-KR) --> 4142B0A1B0A2(EUC-KR) --> 영어라고 판단하고
    //       각 바이트 앞에 00을 붙여서 유니코드로 만든다. 
    //       --> 0041 0042 00B0 00A1 00B0 00A2(Unicode)
    //    => "AB가각"을 정상적인 유니코드로 바꾼다면 다음과 같이 된다.
    //       0041(A) 0042(B) AC00(가) AC01(각)
    //
    //    => 해결책: 클라이언트가 POST로 보낸 데이터가 어떤 문자집합인지 
    //             getParameter()를 최.초.로. 호출하기 전에 알려줘라!
    //             getParameter()를 단 한번이라도 호출한 후에는 알려줘봐야 무시된다.
    //       request.setCharacterEncoding("문자집합명");
    
    request.setCharacterEncoding("UTF-8"); //POST 요청에 대해서만 적용된다.
    // UTF-8 ---> Unicode(2byte) 변환
    
    String name = request.getParameter("name");
    int age = Integer.parseInt( request.getParameter("age") );

    System.out.println(name);
    System.out.println(age);
    
    response.setContentType("text/html;charset=UTF-8");
    // Unicode(2byte) ---> UTF-8 변환 
    
    // 자바는 내부에서 문자열을 다룰 때 항상 Unicode(2byte)로 다룬다.
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("  <head>");
    out.println("    <title>step01/test04</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("  <p>이름: " + name + "</p>");
    out.println("  <p>나이: " + age + "</p>");
    out.println("  </body>");
    out.println("</html>");
  }
}



















