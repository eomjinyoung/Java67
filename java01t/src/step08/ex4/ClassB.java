package step08.ex4;

public class ClassB {
  static int value = 100;
  
  static {
    value = ClassA.m();
    System.out.printf("$$ClassA.value = %d\n", ClassA.value);
    System.out.printf("$$ClassB.value = %d\n", value);
  }
  
  public static int m() {
    System.out.println("$$m()");
    return 888;
  }
}
