package step21.ex6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

// 실습 목표: 초 간단 웹 브라우저 만들기
// => HTTP 프로토콜에 맞추어 서버와 통신한다.
//
// Hyper(고수준의) Text: 다른 문서와 연결을 정보를 포함하는 텍스트.
// Markup(Metadata) : 출판 용어. 텍스트에 대해 어떻게 처리해야 하는지 알려주는 명령어.
//

// HTML(Hyper-Text Markup Language) 
// => 문서 안에 다른 문서의 위치 정보를 삽입하여 문서 간 연결을 쉽게 할 수 있도록 도와줌.
// => 논문 간의 연결을 위해 개발됨.
// => 특정 애플리케이션이 없어도 사용자가 작성 가능하다.
// => 기존 방식
//    . FTP나 메일을 사용하여 논문을 주고 받음.
//    . 논문을 읽다가 다른 논문을 보고 싶으면, 그 논문이 있는 서버에 접속하여 다운로드 받는다.
//    . 다운로드 받은 논문의 해당 부분을 찾는데 시간이 걸린다.
// => HTML 문서를 보다 효율적으로 주고 받기 위해 새로운 프로토콜 개발이 필요하였음.
//    => Hyper-Text Transfer Protocol(HTTP) 등장!
//
// HTTP 프로토콜
// => 등장 배경: HTML 문서를 주고 받기 위해 개발됨.
// => Connectionless(Stateless) 방식을 취하게 된 이유.
//    . 논문을 주고 받을 때는 FTP 처럼 사용자 로그인을 할 필요는 없다. 
//    . 논문을 받은 다음에는 특별한 경우가 아니면 서버와 연결을 계속할 필요가 없다.
// 
//
// HTTP 통신을 하는 프로그램
// => 서버: HTTP Server라고 부름. 
// => 클라이언트: HTTP Client라고 부름.
// => 문서 간의 연결 구조를 보니 거미줄처럼 얽혀 있다고 해서 Web이라고 부른다.
//    HTTP Server => Web Server 명칭을 주로 사용.
//    HTTP Client => Web Browser(문서들을 둘러본다라는 의미)라고 부른다.
//
// Web Browser
// => 논문을 보다 쉽게 볼 수 있는 애플리케이션이다.
// => 곧 문서 보는 용도!
//    . 화면 출력 정책이 문서 보는 구조에 맞춰져 있다. 
//    . 예: 왼쪽에서 오른쪽으로 출력이 흐른다. 
//          더이상 오른쪽으로 출력할 수 없으면, 줄바꿈 한다.
//
// 이슈 등장! 
// => 웹 기술이 문서가 아닌 애플리케이션 UI를 만드는 방향으로 확대됨.
// => 새로운 요구가 발생!
//    . 애플리케이션 UI를 만드는 기술 필요. (HTML에 UI 기능 추가)
//    . UI의 모양을 다루는 기술 필요. (CSS)
//    . 사용자가 UI에 대해 액션을 가하는 경우, 그 액션을 처리하는 기술 필요. (JavaScript)
// 
// 현재의 웹 기술? 
// => 애플리케이션 UI를 생성하는 기술.
// => 서버와의 통신을 다루는 기술.
// 
// HTTP 요청 프로토콜 
// GET /index.html HTTP/1.1 CRLF => 요청 라인(메서드 SP URI SP HTTP프로토콜/버전) 
// Host: www.google.com CRLF => 요청 헤더(헤더명: 값)
// 기타 헤더명 : 값 CRLF
// CRLF => 빈 줄(empty line)
//
// HTTP 응답 프로토콜
// HTTP/1.1 200 OK CRLF => 응답 상태 정보(프로토콜명/버전 SP 코드번호 SP phrase)
// Content-Type: text/html;charset=UTF-8 CRLF => 응답 헤더(헤더명: 값)
// 기타 헤더명: 값 CRLF
// CRLF => 빈 줄(empty line)
// 클라이언트가 출력한 내용 => message body 라고 부름.
//
public class Test1 {

  public static void main(String[] args) throws Exception {
    // HTTP Server의 기본 포트 번호는 80번이다.
    Socket socket = new Socket("dic.naver.com", 80);
    BufferedReader in = new BufferedReader(
        new InputStreamReader( // 바이트 스트림을 문자 스트림에 연결
            socket.getInputStream()));
    PrintStream out = new PrintStream(socket.getOutputStream());

    // 서버에 기본 콘텐츠를 요청한다.
    //out.println("GET / HTTP/1.1");
    out.println("GET /search.nhn?dicQuery=computer&query=computer&target=dic&ie=utf8&query_utf=&isOnlyViewEE= HTTP/1.1");
    out.println("Host: dic.naver.com");
    out.println();

    // 서버가 응답한 내용 읽기
    String line = null;
    do {
      line = in.readLine();
      System.out.println(line);
    } while (!line.equals(""));

    // 내부에서 바이트 배열을 생성하여 데이터를 보관한다.
    int c = -1;
    try {
      while ((c = in.read()) != -1) {
        System.out.print((char)c);
      }
    } catch (Exception e) {}

    try {in.close();} catch (Exception e) {}
    try {out.close();} catch (Exception e) {}
    try {socket.close();} catch (Exception e) {}
  }

}









