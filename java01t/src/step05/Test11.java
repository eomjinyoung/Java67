package step05;

/* 프로그램 아규먼트
 * - 자바 클래스를 실행할 때 main() 메서드에 넘겨주는 값.
 * - How?
 * java -classpath ... step05.Test11 aaa bbb ccc
 * 
 * - 클래스 이름 뒤에 주고 싶은 값을 문자열로 나열한다.
 * - 각각의 값은 공백으로 구분한다.
 */

public class Test11 {

  public static void main(String[] args) {
    //예: java step05.Test11 aaaa bbbb cccc
    //1. JVM은 각각의 문자열을 배열에 넣는다.
    //2. 그 배열의 주소를 main()을 호출할 때 넘겨준다. 
    
    System.out.printf("프로그램 아규먼트 개수: %d\n", args.length);
    for (String value : args) {
      System.out.println(value);
    }
    

  }

}





