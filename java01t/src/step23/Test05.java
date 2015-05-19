package step23;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;


/* 실습 목표: 인스턴스 생성하기
 * 
 */
public class Test05 {
  static class MyClass {
    public int plus(int a, int b) {
      return a + b;
    }
    public int minus(int a, int b) {
      return a - b;
    }
  }
  
  public static void main(String[] args) throws Exception {
    //1) 일반적인 방법 
    MyClass p = new MyClass();
    System.out.println(p.plus(10, 20));
    
    //2) Class 도구를 이용하여 인스턴스를 생성
    Class clazz = MyClass.class;
    MyClass p2 = (MyClass)clazz.newInstance();
    System.out.println(p2.minus(10, 20));
    
    
  }

}










