package step08.ex4;

public class ClassA {
  static int value = 100;
  
  static {
    value = ClassB.m();
    System.out.printf("ClassB.value = %d\n", ClassB.value);
    System.out.printf("ClassA.value = %d\n", value);
  }
  
  public static int m() {
    System.out.println("m()");
    return 555;
  }
}
