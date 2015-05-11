package net.bitacademy.java67.step07.ex1.after;

public class PlusCalc extends Filter {

  public PlusCalc(Filter next) {
    super(next, "+");
  }

  @Override
  public int doFilter(int a, int b) {
    return a + b;
  }
}
