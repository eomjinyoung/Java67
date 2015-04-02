package step19.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 실습 목표: DB 연결자 얻기
 * => java.sql.Connection 구현체를 얻기
 * => 방법:
 *    1) DriverManager에게 요청한다.
 *    2) DriverManager는 등록된 Driver 구현체에게 요청한다.
 *    3) Driver 구현체는 Connection 구현체를 생성한 후 리턴한다.
 *    4) DriverManager는 Driver가 리턴한 객체를 호출자에게 다시 리턴한다.
 *    
 */
public class T04_Connection {

  public static void main(String[] args) {
    try {
      //1. 드라이버 구현체를 등록한다.
      //   => java.sql.Driver 인터페이스를 구현한 클래스의 인스턴스 주소를 등록한다.
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      System.out.println("MySQL Driver 구현체 등록 완료!");
      
      //2. DB 연결자 얻기
      //DriverManager.getConnection()
      // 첫 번째 파라미터: JDBC URL(DBMS 마다 형식이 약간 다르다)
      // 두 번째 파라미터: DBMS 사용자 아이디
      // 세 번째 파라미터: 암호
      // 리턴 값: java.sql.Connection 구현체 
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java67db", /* DBMS 서버의 주소 및 데이터베이스 연결 정보 */  
          "java67", /* 로그인 아이디 */
          "java67"); /* 암호 */
      System.out.println("DBMS 접속 완료!");
      
    } catch (SQLException e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    }

  }

}











