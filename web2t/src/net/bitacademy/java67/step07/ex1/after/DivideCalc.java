package net.bitacademy.java67.step07.ex1.after;

public class DivideCalc extends Filter {

  public DivideCalc(Filter next) {
    super(next, "/");
  }

  @Override
  public int doFilter(int a, int b) {
    return a / b;
  }

  
}
