package net.bitacademy.java67.step07.ex1.after;

public abstract class Filter {
  Filter next;
  String name;
  
  public Filter(Filter next, String name) {
    this.next = next;
    this.name = name;
  }
  
  public int compute(String op, int a, int b) {
    if (op.equals(name)) {
      return doFilter(a, b);
      
    } else if (next != null) {
      return next.compute(op, a, b);
      
    } else {
      throw new RuntimeException("해당 연산자가 없습니다.");
    }
  }
  
  public abstract int doFilter(int a, int b);
}













