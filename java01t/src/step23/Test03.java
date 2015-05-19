package step23;

import java.lang.reflect.Field;


/* 실습 목표: 필드(클래스 변수나 인스턴스 변수) 정보 추출하기
 * 
 */
public class Test03 {
  static class MyClass {
    //인스턴스 변수
    public int a;
    int b;
    protected int c;
    private int d;
    
    //클래스 변수
    public static int e;
    static int f;
    protected static int g;
    private static int h;
  }
  public static void main(String[] args) {
    Class clazz = MyClass.class;
   
    //1) public 변수에 대해서만 정보를 추출할 수 있다.
    Field[] list = clazz.getFields();
    for (Field f : list) {
      Class type = f.getType();
      System.out.printf("변수명(%s), 타입(%s)\n", f.getName(), type.getName());
    }
    
    
  }

}










