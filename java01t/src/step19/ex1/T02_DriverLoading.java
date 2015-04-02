package step19.ex1;


/* 실습 목표: JDBC 드라이버 로딩 다른 방법!
 * => Class.forName("드라이버 클래스 전체 이름");
 *    - 지정된 패키지의 클래스를 단순히 로딩한다.
 *    - 나중에 DriverManager가 필요하다가 생각되는 시점에 자동으로 객체를 만들어 사용한다.
 */
public class T02_DriverLoading {

  public static void main(String[] args) {
    try {
      //1. 드라이버 구현체를 등록한다.
      //   => java.sql.Driver 인터페이스를 구현한 클래스의 인스턴스 주소를 등록한다.
      //   => MySQL 드라이버 파일: com.mysql.jdbc.Driver
      //   => Oracle 드라이버 파일: oracle.jdbc.driver.OracleDriver
      //   => MS-SQL 드라이버 파일: com.microsoft.sqlserver.jdbc.SqlServerDriver
      //
      //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      
      // JDBC 드라이버 클래스를 문자열을 사용하여 로딩한다.
      // 기존 방식 문제점: 
      //    => 명시적으로 JDBC 드라이버 객체를 생성한다. 
      //    => 자바 코드에서 해당 패키지를 언급한다. => DBMS에 종속된다.          
      // 이점: 
      //    => 자바 코드에서 특정 패키지의 클래스를 사용하지 않는다. => DBMS 비종속
      //    => 엥? 거짓말! 문자열에 mysql 클래스라고 되어 있네. 
      //       => 하하. 이건 그냥 Class.forName()을 사용할 수 있다는 것을 보여주기 위해
      //          간단히 만든 것임.
      //    => 그럼 제대로 만든다면 어떻게 할 건 데?
      //       => 프로그램 실행할 때 프로그램 아규먼트로 받겠지.
      //          그러면, 다음과 같이 코딩하겠지.
      //          예) Class.forName(args[0]);
      //    => 막연하다. 직접 보여달라! 
      //       => T03_xx 예제를 보라!
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("MySQL Driver 구현체 등록 완료!");
      
    } catch (Exception e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    }

  }

}











