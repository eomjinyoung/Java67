package step14.ex5;

// 예외 처리 문법으로 오류를 다루기
// - 예외를 던지는 메서드를 호출할 때는 반드시 그 예외를 처리해야만 컴파일 할 수 있다.
// - 즉, 예외 처리(오류 처리)를 강제화시킨다.
// - 예외 처리 문법
/*   try {
 *      예외가 발생하는 코드
 *   } catch (예외 객체를 받을 파라미터) {
 *      예외 처리 코드
 *   } finally { //선택 사항
 *      오류가 발생하든 안하든 반드시 실행해야 할 코드 
 *   }
 */
public class Test4 {

  public static void main(String[] args) {
    // 예외 처리 도입 전 : 예외를 처리하지 않아도 컴파일 할 때 문제없다.
    MyArrayList3 array = new MyArrayList3();
    for (int i = 0; i < 101; i++) {
      array.add("홍길동" + i);
    }
    
    MyArrayList3 array2 = new MyArrayList3();
    array2.add("홍기동");
    array2.add("김기동");
    array2.add("박기동");
    
    array2.remove(0);
    array2.remove(0);
    array2.remove(0);
    array2.remove(0);
    array2.remove(200);
    
    //예외 처리 도입 후: 
    // - 실행해야 할 코드와 예외 처리 코드를 분리 => 코드를 읽기가 쉽다.
    // - 예외 처리를 강제한다.
    try {
      MyArrayList4 array3 = new MyArrayList4();
      for (int i = 0; i < 101; i++) {
        array3.add("홍길동" + i);
      }
    } catch (Throwable ex) {
      System.out.println("추가하다가 예외가 발생했음: " + ex.getMessage());
    }
    
    try {
      MyArrayList4 array4 = new MyArrayList4();
      array4.add("홍기동");
      array4.add("김기동");
      array4.add("박기동");
      
      array4.remove(0);
      array4.remove(0);
      array4.remove(0);
      array4.remove(0);
      array4.remove(200);
    } catch (Throwable ex) {
      System.out.println("더하거나 지우다가 예외 발생!");
    }
  }

}








