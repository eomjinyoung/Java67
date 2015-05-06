package net.bitacademy.java67;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 실습 목표: 
// 1. 서블릿 클래스 만들기
//    - javax.servlet.Servlet 인터페이스를 구현해야 한다.
//    - 왜? 서블릿 컨테이너는 Servlet 인터페이스에 정의된 메서드를 호출한다.
// 
// 2. 서블릿을 톰캣 서버에 배치하기
//    1) 웹 애플리케이션 디렉토리를 생성한다.
//      => $tomcat_home/webapps/myapp
//    2) 웹 애플리케이션 디렉토리에 컴파일된 클래스 파일을 둔다.(패키지 경로 유지할 것)
//      => $tomcat_home/webapps/myapp/WEB-INF/classes
//    3) 서블릿을 웹 애플리케이션에 등록한다.
//      => $tomcat_home/webapps/myapp/WEB-INF/web.xml 
//
// 3. 서블릿 실행을 테스트하기
//    - 톰캣 서버를 실행한다.
//      => $tomcat_home/bin/startup.bat 
//
//    - 웹 브라우저 주소 창에 URL을 입력한다.
//      => http://localhost:9999/myapp/test00/hello
//
// * javax.servlet.Servlet 인터페이스
// - 서블릿 컨테이너와 서블릿 프로그램 사이의 호출 규칙이다.
// - 클라이언트에서 요청이 들어오면, 서블릿 컨테이너는 규칙에 따라 
//   Servlet 인터페이스의 메서드를 호출한다.
// 
// * 웹 애플리케이션 배치 폴더: $tomcat_home/webapps
// - 톰캣 서버의 경우 웹 애플리케이션은 webapps 라는 디렉토리에 배치해야 한다.
//
// * 웹 애플리케이션 폴더 구조
// myapp/WEB-INF/classes 
//     ==> 자바 클래스 파일(.class) 또는 프로퍼티 파일(.properties)을 둔다.
// myapp/WEB-INF/lib
//     ==> 자바 라이브러리 파일(.jar)을 둔다.
// myapp/WEB-INF/web.xml
//     ==> 웹 애플리케이션의 설정 정보를 둔다.
// myapp/ 
//     ==> HTML, CSS, JavaScript, JSP, 그림 파일 등을 둔다.
// 주의!
//     ==> WEB-INF 폴더 밑에 있는 파일은 웹 브라우저에서 요청할 수 없다.
//         따라서 WEB-INF 폴더에 HTML, JSP, CSS, JavaScript 등을 두지 말라!
//
// * 임시 배치 폴더: 워크스페이스폴더/.metadata/.plugins/...server.core/tmp0/wtpwebapps
//     ==> 개발하는 동안 웹 애플리케이션을 테스트할 목적으로 사용하는 임시 폴더.
//     ==> 이클립스의 플러그인을 사용하여 톰캣을 실행할 때는 이 임시 폴더에 배치해야 한다.
//     ==> 위에서 한 것과 같이 개발자가 따로 배치를 수행할 필요는 없다.
//     ==> 이클립스 웹 개발 플러그인(Web Tools Platform)이 자동으로 임시 폴더에 배치한다.
//     ==> 개발하는 동안 직접 파일 탐색기나 명령창에서 톰캣 서버를 실행하지 말라!
//
// * 자동 배치 방법
// 1) Servers 뷰에 톰캣 개발 환경을 생성한다. 예) BIT Server, study server
// 2) 톰캣 실행 환경에 웹 프로젝트를 추가하라.
//    Servers 뷰 > study server > 컨텍스트 메뉴 
//                   > Add and remove ... > 웹 프로젝트 추가!
// 3) 톰캣 서버 실행
//    Servers 뷰 > study server 선택 > 플레이 버튼 클릭
// 
// 4) 톰캣 서버 실행 확인
//    Console 뷰 > 출력 내용 확인 (내용 중에 오류가 없는지 주의 깊게 확인하라!)
//
// * 웹 프로젝트 폴더 구조
// 1) src : 자바 소스 파일 및 프로퍼티 파일을 둔다.
// 2) WebContent : 톰캣 서버에 배치할 HTML, CSS, JavaScript, 그림 파일 등을 둔다.
//                 WEB-INF 폴더도 이 디렉토리에 둔다.
// 3) WebContent/WEB-INF/classes : 따로 만들 필요가 없다. 
//                                 톰캣 서버에 배치할 때 자동으로 만든다.
//                                 build/classes 폴더에 있는 파일을 자동으로 복사한다.
//
//
// * 자동 배치 과정
// 톰캣 서버를 실행하면 다음과 같이 웹 애플리케이션을 자동으로 배치한다.
// 1) 웹 애플리케이션 폴더 생성
//    ==> 워크스페이스폴더/.metadata/.plugins/...server.core/tmp0/wtpwebapps/ 폴더에
//        웹 프로젝트의 컨텍스트 이름(기본: 웹 프로젝트명)으로 하위 폴더를 만든다.
// 2) 프로젝트폴더/WebContent/ 폴더의 모든 파일 및 디렉토리
//    ==> 워크스페이스폴더/.metadata/.plugins/...server.core
//                 /tmp0/wtpwebapps/웹애플리케이션폴더/ 에 그대로 복사한다. 
// 3) 프로젝트폴더/build/classes/* 자바 클래스 파일(.class)
//    ==> 웹애프리케이션폴더/WEB-INF/classes/ 폴더에 그대로 복사한다.
//
// 주의! 가끔 자동으로 복사되지 않는 경우가 있다. WTP 플러그인의 버그이다.
// 해결방법:
// 1) 톰캣 서버에서 해당 프로젝트를 제거한 후, 
//    웹애플리케이션이 없는 상태에서 톰캣 서버를 다시 실행하라!
// 2) 임시 폴더(tmp0/wtpwebapps/)에서 정확하게 제거되었는지 확인하라!
//    분명히 제거했는데도 폴더가 삭제되지 않는 경우가 있다.
// 3) 다시 톰캣 서버에 프로젝트를 추가한 다음, 다시 시작시켜라!
//    개발 PC가 느린경우 복사하는데 시간이 걸린다. 
//      => 프로젝트를 추가한 후 바로 시작시키지 말고, 천천히 서버를 시작시켜라!
// 4) 임시 폴더에 제대로 배치(복사) 되었는지 확인하라!
//    => 될 때까지 위 과정을 반복하라! (충고, PC 교체하라!)
public class Hello implements Servlet {

  @Override
  public void destroy() {
    System.out.println("destroy() 호출됨");
    
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("getServletConfig() 호출됨");
    return null;
  }

  @Override
  public String getServletInfo() {
    System.out.println("getServletInfo() 호출됨");
    return null;
  }

  @Override
  public void init(ServletConfig arg0) throws ServletException {
    System.out.println("init() 호출됨");
    
  }

  @Override
  public void service(ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
    System.out.println("service() 호출됨");
    
  }

}






