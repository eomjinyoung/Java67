package step06.ex2;

public class Engine {
  String  maker;
  int     cc;
  int     valve;
  
  @Override
  public String toString() {
    return "Engine [maker=" + maker + ", cc=" + cc + ", valve=" + valve + "]";
  }
  
  public Engine() {
    System.out.println("Engine() 생성");
  }
  
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    System.out.println("Engine.setMaker() 호출");
    this.maker = maker;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    System.out.println("Engine.setCc() 호출");
    this.cc = cc;
  }
  public int getValve() {
    return valve;
  }
  public void setValve(int valve) {
    System.out.println("Engine.setValve() 호출");
    this.valve = valve;
  }
  
  
}
