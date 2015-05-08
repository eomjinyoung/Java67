package net.bitacademy.java67.step03.ex1;

public class Test01 {
  public static void main(String[] args) {
    Tico c = new Tico();
    c.model = "하하하";
    c.cc = 800;
    
    Car temp = c;
    
    Container2 c2 = new Container2();
    c2.add(temp);
    
    
  }
}
