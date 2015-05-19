package step23;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;


/* 실습 목표: 메서드 정보 추출하기
 * 
 */
public class Test04 {
  static class MyClass {
    public int plus(int a, int b) {
      return a + b;
    }
    public int minus(int a, int b) {
      return a - b;
    }
  }
  public static void main(String[] args) {
    Class clazz = MyClass.class;
   
    //1) 메서드 정보 추출하기(public 만 추출할 수 있다.)
    Parameter[] params = null;
    Method[] list = clazz.getMethods();
    System.out.println("public여부, static여부, 리턴타입, 메서드명, ");
    for (Method m : list) {
      System.out.printf("%s %s %s %s()\n",
          (m.getModifiers() & Modifier.PUBLIC) > 0 ? "public":"",
          (m.getModifiers() & Modifier.STATIC) > 0 ? "static":"",
          m.getReturnType().getSimpleName(),
          m.getName());
      
      params = m.getParameters();
      for (Parameter p : params) {
        System.out.printf("    %s %s\n", 
            p.getType().getSimpleName(), 
            p.getName());
      }
    }
    
    
  }

}










