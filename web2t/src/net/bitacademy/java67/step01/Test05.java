package net.bitacademy.java67.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 실습 목표: 파라미터 값 꺼내기

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
                       
    
    String name = request.getParameter("name");
    int age = Integer.parseInt( request.getParameter("age") );

    System.out.println(name);
    System.out.println(age);
    
    response.setContentType("text/html;charset=UTF-8");
    
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



















