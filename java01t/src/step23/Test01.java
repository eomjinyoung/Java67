package step23;

/* 실습 목표: Class 객체 얻기
 * Class 클래스
 * - 클래스 정보를 다루는 도구
 *  
 */
public class Test01 {
  public static void main(String[] args) throws Exception {
    // Class 객체 얻기
    // 1) Class.forName()을 사용하여 Class 객체 얻기
    Class c1 = Class.forName("java.lang.String");
    
    // 2) 클래스의 스태틱 변수를 통해 얻기
    Class c2 = String.class;
    
    // 3) 인스턴스를 통해서 얻기
    String s = "홍길동";
    Class c3 = s.getClass();
    

  }

}







