package step23;

import java.lang.reflect.Method;



/* 실습 목표: 메서드 호출하기
 * 
 */
public class Test06 {
  static class MyClass {
    public int plus(int a, int b) {
      return a + b;
    }
    public int minus(int a, int b) {
      return a - b;
    }
  }
  
  public static void main(String[] args) throws Exception {
    MyClass p = new MyClass();
    Class clazz = p.getClass();
    Method m = clazz.getMethod("plus", int.class, int.class);
    System.out.println(m.invoke(p, new Object[]{30, 20}));
  }

}










