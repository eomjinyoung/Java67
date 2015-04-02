package step19.ex1;

import java.sql.DriverManager;
import java.sql.SQLException;

/* JDBC 프로그래밍
 * 
 * 1. 프로그래밍 준비
 * 1) JDBC 드라이버 다운로드
 * 2) 프로젝트에 JDBC 드라이버 파일의 위치 등록
 *    => 컴파일하고 실행할 때 사용하기 위해 라이브러리 등록
 *    프로젝트 속성 => Java Build Path => Libraries => 'Add Jars...' 버튼 클릭!
 * 
 * 2. JDBC 드라이버 사용 준비
 * => java.sql.Driver 객체를 드라이버 관리자에 등록한다.   
 * => 드라이버 관리자: java.sql.DriverManager 클래스.
 */
public class T01_DriverLoading {

  public static void main(String[] args) {
    try {
      //1. 드라이버 구현체를 등록한다.
      //   => java.sql.Driver 인터페이스를 구현한 클래스의 인스턴스 주소를 등록한다.
      //   => MySQL 드라이버 파일: com.mysql.jdbc.Driver
      //   => Oracle 드라이버 파일: oracle.jdbc.driver.OracleDriver
      //   => MS-SQL 드라이버 파일: com.microsoft.sqlserver.jdbc.SqlServerDriver
      //
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      System.out.println("MySQL Driver 구현체 등록 완료!");
      
    } catch (SQLException e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    }

  }

}











