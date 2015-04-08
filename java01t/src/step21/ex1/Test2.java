package step21.ex1;

import java.awt.Frame;

//실습 목표: 윈도우 만들기
//=> Frame 클래스를 상속 받기
//
//
 
public class Test2 extends Frame {
  private static final long serialVersionUID = 1L;

  public Test2(String title) {
    super(title);
    
    setSize(400, 300);
    setVisible(true);
  }
  
  public static void main(String[] args) {
    new Test2("두 번째 윈도우");
    
  }

}










