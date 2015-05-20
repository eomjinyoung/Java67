package step23;




/* 실습 목표: Class 객체 
 * 
 */
public class Test07 {
  public static void main(String[] args) throws Exception {
    String s1 = new String("홍길동");
    String s2 = new String("임꺽정");
    
    Class c1 = s1.getClass(); // String.class
    Class c2 = s2.getClass(); // String.class 
    Class c3 = String.class;
    
    if (c1 == c2) {
      System.out.println("s1의 타입과 s2의 타입이 같다!");
    }
    
    if (c1 == c3) {
      System.out.println("s1의 타입과 s3의 타입이 같다!");
    }
    
  }

}










