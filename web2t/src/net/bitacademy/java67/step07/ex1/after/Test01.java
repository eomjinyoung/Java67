package net.bitacademy.java67.step07.ex1.after;

public class Test01 {

  public static void main(String[] args) {
    DivideCalc c4 = new DivideCalc(null);
    //MultipleCalc c3 = new MultipleCalc(c4);
    PlusCalc c3 = new PlusCalc(c4);
    MinusCalc c2 = new MinusCalc(c3);
    
    
    try {  
      System.out.println(c2.compute("+", 10, 20)); 
    } catch (Throwable e) {
      System.out.println("연산자 없음!");
    }
    
    try {  
      System.out.println(c2.compute("-", 10, 20)); 
    } catch (Throwable e) {
      System.out.println("연산자 없음!");
    }
    
    try {  
      System.out.println(c2.compute("*", 10, 20)); 
    } catch (Throwable e) {
      System.out.println("연산자 없음!");
    }
    
    try {  
      System.out.println(c2.compute("/", 10, 20)); 
    } catch (Throwable e) {
      System.out.println("연산자 없음!");
    }
  }

}
