package step19.ex1;


/* 실습 목표: 프로그램 아규먼트를 통해 JDBC 드라이버 이름 지정하기
 * 예) java -classpath ... T03_DriverLoading com.mysql.jdbc.Driver(엔터)
 * => Class.forName(args[0]);
 * 
 */
public class T03_DriverLoading {

  public static void main(String[] args) {
    try {
      System.out.printf("args[0]: %s\n", args[0]);
      
      //이렇게 프로그램을 실행할 때 외부에서 JDBC 드라이버 클래스 이름을 받아서 
      //로딩한다면, 애플리케이션은 특정 DBMS에 종속되지 않는다.
      Class.forName(args[0]);
      System.out.println("MySQL Driver 구현체 등록 완료!");
      
    } catch (Exception e) {
      e.printStackTrace(); // 오류에 대한 상세 정보를 콘솔 창에 출력한다.
    }

  }

}











